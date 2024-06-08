# 페어의 노드 스왑

연결 리스트를 입력 받아 페어(Pair) 단위로 스왑하라.

> 입력: 1 -> 2 -> 3 -> 4 -> 5 -> 6
> 
> 출력: 2 -> 1 -> 4 -> 3 -> 5 -> 6

우선 가장 단순한 풀이는, 페어 단위로 `value`만 바꿔치기 하는 것이다.

연결 리스트의 구조를 깨지 않고, 페어 단위로 `value`만 바꿔치면서도 충분히 빠르고 직관적으로 풀이할 수 있다.

```java
import linear_data_structure.linked_list.ListNode;

void swapPairsByChangingValue(ListNode node) {
    while (node != null) {
        int tmp = node.value;
        node.value = node.next.value;
        node.next.value = tmp;
        
        node = node.next.next;
    }
}
```

`node = node.next.next;` 해당 코드를 통해, 우리는 두칸씩 이동한다.

값을 스위칭할 때, `tmp 변수`를 활용하는 것은 어렵지 않다. 많이 봐왔던 것이다.

두번째로는, `노드가 가리키는 다음 노드 자체를 바꿔버리는 방법`이다.

`a -> b -> c -> d` 의 구조를 생각해보자.

a.next = b.next (= c)

b.next = a

=> b -> a -> c -> d

```java
import linear_data_structure.linked_list.ListNode;

ListNode swapPairsByChangingNextNode(ListNode head) {
    ListNode node = new ListNode(-1, null);
    ListNode root = node;
    node.next = head;
    
    while (node.next != null) {
        ListNode a = node.next;
        ListNode b = node.next.next;
        a.next = b.next;
        node.next = b;
        node.next.next = a;
        node = node.next.next;
    }
    
    return root.next;
}
```

`TODO` 재귀 풀이도 있다.

