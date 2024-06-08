# 팰린드롬 연결 리스트

연결 리스트가 팰린드롬 구조인지 판별하는 문제이다.
> 1 -> 2 -> 3 -> 2 -> 1


팰린드롬인지 확인하기 위해, 우리는 첫 번째부터 왼쪽으로, 맨 마지막부터 왼쪽으로 오면서 값을 비교해볼 수 있다.

1. 스택을 활용하기

연결 리스트의 값들을 스택 자료구조에 쌓아두면, 스택에서 값을 꺼낼 때는 마지막 값부터 꺼낼 수 있다.

이 점을 활용하는 것이다.

`head.value 와 stack.pop()` 을 비교하기

```java
import linear_data_structure.linked_list.ListNode;

import java.util.LinkedList;

boolean isPalindromeByStack(ListNode head) {
    Deque<Integer> stack = new LinkedList<>();
    ListNode node = head;
    while (node != null) {
        stack.push(node.value);
        node = node.next;
    }
    
    while (head != null) {
        if (head.value != stack.pop()) return false;
        head = head.next;
    }
    
    return true;
}
```
2. Deque 자료구조 활용하기

배열의 양 옆에서 값을 꺼내는 원리를 가장 잘 활용할 수 있는 것은 사실 `Deque 자료구조`이다.

`pollFirst()`와 `pollLast()` 메서드를 활용할 수 있기 때문이다.

```java
import linear_data_structure.linked_list.ListNode;

import java.util.ArrayDeque;

boolean isPalindromeByStack(ListNode head) {
    Deque<Integer> deque = new ArrayDeque<>();
    ListNode node = head;
    while (node != null) {
        deque.add(node.value);
        node = node.next;
    }

    while (!deque.isEmpty()) {
        if (deque.pollFirst() != deque.pollLast()) return false;
    }

    return true;
}
```

아주 직관적이다. 양끝에서부터 다가오며 비교하는 원리를 그대로 소스코드로 보여준다.

3. Runner 기법 활용하기 `TODO`

연결 리스트를 순회할 때 2개의 포인터를 동시에 사용하는 기법을 러너(Runner)라고 한다.

주로 한 포인터가 다른 포인터보다 앞서게 하여 병합 지점이나 중간 위치, 길이 등을 판별할 때 유용하게 사용한다.

하 잘 모르겠다. 나중에 다시 보자. 
