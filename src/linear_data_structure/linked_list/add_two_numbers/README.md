# 두 수의 덧셈

역순으로 저장된 연결 리스트의 숫자를 더 해서, 역순의 연결 리스트로 출력하라

> (2 -> 4 -> 3) + (5 -> 6 -> 2)
> 
> 342 + 265 = 607
> 
> 출력: 7 -> 0 -> 6

`TODO` 전가산기를 구현하는 풀이가 있으나, 그 풀이는 우선 생략하겠다.

1. 연결 리스트를 역순으로 만든다.
2. 역순으로 만들어진 연결 리스트를 숫자로 변환한다.
3. 숫자로 변환된 두 값을 더한다.
4. 그 결과를 역순의 연결 리스트로 출력한다.

각각을 메서드로 구현할 것이다.

1번은 이제 쉽다. 

```java
import linear_data_structure.linked_list.ListNode;

ListNode reverseList(ListNode node) {
    ListNode prev = null;
    while (node != null) {
        ListNode next = node.next;
        node.next = prev;
        prev = node;
        node = next;
    }
    return prev;
}
```

2번, 숫자로 반환하는데, 문제 조건에 아주 큰 값까지 대응이 가능해야했기에 `BigInteger 자료형`을 활용하겠다.

또한 문자열 조작을 위해 `StringBuilder 클래스`를 활용했다. 
```java
import linear_data_structure.linked_list.ListNode;

import java.math.BigInteger;

BigInteger toBigInt(ListNode node) {
    StringBuilder val = new StringBuilder();
    while (node != null) {
        val.append(node.value);
        node = node.next;
    }
    return new BigInteger(val.toString());
}
```

3. 두 값을 더하기보단, 두 리스트를 더하는 메서드를 만들고, 내부적으로 `toBigInt` 메서드를 호출하자.

```java
import linear_data_structure.linked_list.ListNode;

import java.math.BigInteger;

BigInteger addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode l1Reversed = reverseList(l1);
    ListNode l2Reversed = reverseList(l2);

    return toBigInt (l1Reversed).add(toBigInt(l2Reversed));
}
```

4. 숫자를 역순의 연결리스트로 반환한다.

```java
import linear_data_structure.linked_list.ListNode;

import java.math.BigInteger;

ListNode toReversedLinkedList(BigInteger val) {
    ListNode prev = null, node = null;
    for (char c : String.valueOf(val).toCharArray()) {
        node = new ListNode(Character.getNumericValue(c), null);
        node.next = prev;
        prev = node;
    }
    return node;
}

ListNode toReversedLinkedList2(BigInteger val) {
    ListNode node = new ListNode(-1, null);
    ListNode result = node;
    for (char c : String.valueOf(val).toCharArray()) {
        node.next = new ListNode(Character.getNumericValue(c), null);
        node = node.next;
    }
    return reverseList(result.next);
}
```

딱히 이해가 되지 않는 부분은 없고, 풀이 자체가 어려운 편은 아니다.

다만 코드가 길다.

이를 개선하기 위해 `TODO` 전가산기 구현 풀이가 있으나, 우선 건너 뛰겠다!
