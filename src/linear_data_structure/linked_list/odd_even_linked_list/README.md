# 홀짝 연결 리스트

연결 리스트를 홀수 번째 노드 다음에 짝수 번째 노드가 오도록 재구성하라. 공간 복잡도 O(1), 시간 복잡도 O(n)

> 입력: 1 -> 2 -> 3 -> 4 -> 5 -> 6
> 
> 출력: 1 -> 3 -> 5 -> 2 -> 4 -> 6

크게 어렵진 않다.

홀수번째 노드를 연결한 리스트와, 짝수번째 노드를 연결한 리스트를 만들고, 전자의 next 로 후자를 연결하면 된다.

```java
import linear_data_structure.linked_list.ListNode;

ListNode oddEventList(ListNode head) {
    ListNode odd = head;
    ListNode even = head.next;
    ListNode evenHead = even;
    
    while (odd.next != null && even.next != null) {
        odd.next = odd.next.next;
        odd = odd.next;
        
        even.next = even.next.next;
        even = even.next.next;
    }
    odd.next = evenHead;
    
    return head;
}
```
시간 복잡도야 당연히 while 문 한 번에 처리되기에 O(n)이고,

사용한 변수들 (odd, even, evenHead 등) 또한 n의 크기에 관계없이 항상 일정하기에 O(1)이다.
