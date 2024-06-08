# 역순 연결 리스트
> 연결 리스트를 뒤집어라

단순하게 떠오른 아이디어는, `Stack 자료구조`를 활용하는 것이다.

연결 리스트를 Stack 자료구조에 밀어넣고, `pop()` 을 하여 새로운 연결 리스트를 만들면,
그것이 뒤집어진 연결 리스트이기 때문이다.

```java
import linear_data_structure.linked_list.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

ListNode reverseByStack(ListNode head) {
    Deque<Integer> stack = new ArrayDeque<>();

    ListNode node = head;
    while (node != null) {
        stack.push(head.value);
        node = node.next;
    }

    ListNode reversed = new ListNode(-1, null);
    ListNode result = reversed;
    while (!stack.isEmpty()) {
        Integer pop = stack.pop();
        reversed.next = new ListNode(pop, null);
        reversed = reversed.next;
    }
    
    return result.next;
}
```

이건 내가 떠올린 풀이고, 그리 깔끔하진 않은 것 같다 ㅎㅎ

책에서 제시하는 반복문 풀이를 보자. (재귀 풀이도 있지만, 살짝 이해가 안 간다. `TODO`)

```java
import linear_data_structure.linked_list.ListNode;

ListNode reverseForWhile(ListNode head) {
    ListNode prev = null, node = head;

    while (node != null) {
        // 이동할 곳을 미리 선언 (연결이 끊길 것이기 때문)
        ListNode next = node.next;
        // 역순을 가리키도록 방향 수정, node 의 연결을 끊고, 새로 연결을 생성
        node.next = prev;
        // 새로 생성한 연결을 가리킴
        prev = node;
        // 리스트를 마저 순회함. 다만, node.next 는 더이상 기존 리스트의 next 를 가리키고 있지 않기에 미리 기록해둔 곳으로 감.
        node = next;
    }
    
    return prev;
}
```

처음엔 잘 이해하기 어렵다.
하나의 공식 같다.

* `ListNode next = node.next;`

기존 리스트에서, 순회할 다음 참조를 미리 선언한다.

* `node.next = prev;`

기존 리스트의 다음 참조를 이전 것을 가리키게 한다.

* `prev = node;`

우리는 다음에 next 로 이동할 것이기 때문에, 자연스레 현재 node 는 prev 가 된다.
즉, 지금의 node 가 , 그 다음 순번한테는 이전(prev) 이 되는 것이다.

* `node = next;`

이제 다음 순번으로 이동한다.


1 -> 2 -> 3 -> 4 -> 5 -> 6 이 있었다고 가정하자.

1. 첫 반복문
* prev = null
* next = 2
* node.next = prev (= null)
* prev = node (= 1, 현재의 값이 다음 반복문에선 이전의 값이 됨)
* node = next (= 2, 이동)


2. 두 번째 반복문
* prev = 1
* next = 3
* node.next = prev(= 1)
* prev = node (= 2, 다음 순번의 prev 를 지정하는 것)
* node = next (= 3, 이동)


* null <- prev, node -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
* null <- 1 <- prev, 2 -> 3 -> 4 -> 5 -> 6 -> null
* null <- 1 <- 2 <- prev, node -> 3 -> 4 -> 5 -> 6 -> null
* ...
* null <- 1 <- 2 <- 3 <- 4 <- 5 <- 6 <- prev, node -> null

결국 마지막에, node 는 null 을 가리키고, prev 는 node 가 가리키던 것을 가지고 있으니... prev 를 반환한다.

