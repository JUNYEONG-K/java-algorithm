# K 개 정렬 리스트 병합

> K 개의 정렬된 리스트를 1개의 정렬된 리스트로 병합하라
> 
> [1 -> 4 -> 5], [1 -> 3 -> 4], [2 -> 7]
> 
> 1 -> 1-> 2 -> 3 -> 4 -> 4 -> 5 -> 7

우선순위 큐를 활용해서 풀어볼 수 있다.

우선순위 큐의 기준을 `값`으로 지정하면, 큐에서 poll 을 할 때, 무조건 값이 작은 것부터 나오게 된다.

```java
PriorityQueue<ListNode> pq = new PriorityQueue<>(((o1, o2) -> {
    if (o1.value == o2.value) return 0;
    if (o1.value > o2.value) return 1;
    return -1;
}));
```

`pq` 에는 ListNode 의 value 순으로 값이 들어간다.

[1 -> 4 -> 5], [1 -> 3 -> 4], [2 -> 7] 을 순서대로 pq 에 넣고,
`pq.poll()` 을 하면 [1 -> 4 -> 5], [1 -> 3 -> 4], [2 -> 7] 순으로 출력이 된다.

맨 앞단인 1, 1, 2의 대소를 비교하여 pq 에서 저장하고 있기 때문이다.

꺼낸 후, 남은 것들은 다시 pq 에 넣는다. 이후 다시 꺼내고 남은 것들을 넣고의 행위를 반복한다.

즉,

1. `[1 -> 4 -> 5], [1 -> 3 -> 4], [2 -> 7]` 가 들어있는 pq
2. `pq.poll() = [1 -> 4 -> 5]`, 1만 기록하고 나머지 [4 -> 5]는 다시 pq 에 저장
3. `[1 -> 3 -> 4], [2 -> 7], [4 -> 5]` 가 들어있는 pq
4. `pq.poll() = [1 -> 3 -> 4]`, 1만 기록하고 나머지 [3 -> 4]는 다시 pq 에 저장
5. `[2 -> 7], [3 -> 4], [4 -> 5]` 가 들어있는 pq
6. `pq.poll() = [2 -> 7]`, 2만 기록하고 나머지 [7]은 다시 pq에 저장
7. `[3 -> 4], [4 -> 5], [7]` 이 들어있는 pq

위 작업을 반복하면, 기록된 값들이 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 7 의 순서를 가진다.

```java
import linear_data_structure.linked_list.ListNode;

import java.util.PriorityQueue;

ListNode mergeLists(ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>(((o1, o2) -> {
        if (o1.value == o2.value) return 0;
        if (o1.value > o2.value) return 1;
        return -1;
    }));

    for (ListNode list : lists)
        if (list != null) pq.add(list);


    ListNode root = new ListNode(0, null);
    ListNode tail = root;
    while (!pq.isEmpty()) {
        ListNode polled = pq.poll();
        tail.next = new ListNode(polled.value, null);
        tail = tail.next;
        if (polled.next != null) pq.add(polled.next);
    }

    return root.next;
}
```

```java
PriorityQueue<ListNode> pq = new PriorityQueue<>(((o1, o2) -> {
        if (o1.value == o2.value) return 0;
        if (o1.value > o2.value) return 1;
        return -1;
    }));
```

위 코드는 최종적으로 아래 코드로까지 수정할 수 있다.

```java
PriorityQueue<ListNode> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o.value)));
```
