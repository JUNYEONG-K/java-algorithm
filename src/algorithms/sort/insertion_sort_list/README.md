# 삽입 정렬 리스트

> 연결 리스트를 삽입 정렬로 정렬하라.

```java
import linear_data_structure.linked_list.ListNode;

public ListNode insertionSort(ListNode head) {
    ListNode parent = new ListNode();
    ListNode p = parent;
    
    while (head != null) {
        while (p.next != null && p.next.value < head.value)
            p = p.next;
        ListNode pNext = p.next;
        ListNode headNext = head.next;
        p.next = head;
        head.next = pNext;
        head = headNext;
        
        if (head != null && p.value > head.value) p = parent;
    }
    return parent.next;
}
```
