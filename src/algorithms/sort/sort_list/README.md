# 리스트 정렬

> 연결 리스트를 O(NlogN)에 정렬하라.

코딩 테스트 시 정렬을 직접 구현할 일은 거의 없지만, 
이 문제는 입력값을 배열이 아닌 연결 리스트로 주기 때문에 정렬을 직접 구현할 수 밖에 없는 좋은 문제다.
또한 시간복잡도도 `O(NlogN)`에 맞추어야 한다.

연결 리스트 입력에 대해서는 자바에서 정렬할 수 있는 별도 메서드는 제공하지 않는다.

우리는 병합 정렬로 시도해보자.

병합정렬의 분할 정복을 위해서는 중앙을 분할해야 한다. 다만 연결 리스트는 전체 길이를 알 수 없기 때문에 `러너 Runner` 기법을 활용해야 한다.

```java
import linear_data_structure.linked_list.ListNode;

ListNode half = null, slow = head, fast = head;
while (fast != null && fast.next !=null) {
    half = slow;
    slow = slow.next;
    fast = fast.next.next;
}
```
slow 는 한 칸식, fast 는 두 칸씩 앞으로 이동한다. 그럼 fast 가 맨 끝에 도달했을 때, slow 는 중앙에 위치해있다.
half 는 slow 의 바로 직전 노드 값이 된다.

`half.next = null`

이후, 위 코드를 작성하면, half 를 기준으로 반이 나뉘게 된다. (head: 시작 노드, slow: 반 나뉘어진 뒷 노드)

우리의 연결 리스트는 `head -> -1 -> 5 (half)` 와 `slow -> 3 -> 4 -> 0` 으로 나뉜다.
각각에 대해 재귀적으로 메서드를 다시 호출해보자.

```java
ListNode l1 = sortList(head);
ListNode l2 = sortList(slow);
```
이렇게 재귀적으로 호출을 하게 되면, 최종적으로는 `-1, 5, 3, 4, 0`과 같이 단일 아이템으로 모두 쪼개진다.

이후부터는 정복을 시작한다.
```java
mergeTwoLists(l1, l2);
```
이 메서드는 단순히 두 배열을 합치는 것이 아니라, 크기 비교를 통해 정렬하면서 이어 붙인다.

```java
import linear_data_structure.linked_list.ListNode;

public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    
    if (l1.value > l2.value) {
        ListNode temp = l1;
        l1 = l2;
        l2 = temp;
    }
    
    l1.next = mergeTwoLists(l1.next, l2);
    return l1;
}
```
혹은 아래와 같이 작성할 수도 있다.
```java
import linear_data_structure.linked_list.ListNode;

public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    
    if (l1.value < l2.value) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    } else {
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}
```


최종 코드는 아래와 같다.

```java
import linear_data_structure.linked_list.ListNode;

public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    if (l1.value < l2.value) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    } else {
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}

public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;
    
    ListNode half = null, slow = head, fast = head;
    while (fast != null && fast.next != null) {
        half = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    half.next = null;
    
    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);
    
    return mergeTwoLists(l1, l2);
}
```