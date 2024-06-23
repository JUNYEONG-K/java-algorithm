# BFS 너비 우선 탐색

너비 우선 탐색은 큐를 활용해 구현할 수 있다.

* 수도 코드

```
BFS(G, start_v)
    let Q be a queue
    label start_v as discovered
    Q.enque(start_v)
    while Q is not empty do
        v := Q.dequeue()
        for all edges from v to w in G.adjacentEdges(v) do
            if w is not labeled as discovered then
                label w as discovered
                w.parent := v
                Q.enqueu(w)
```

이를 자바 코드로 구현하면 아래와 같다.

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

List<Integer> iterativeBFS(int start_v) {
    List<Integer> discovered = new ArrayList<>();
    discovered.add(start_v);

    Queue<Integer> queue = new LinkedList<>();
    queue.add(start_v);
    
    while (!queue.isEmpty()) {
        int v = queue.poll();
        for (int w : graph.get(v)) {
            if (!discovered.contains(w)) {
                discovered.add(w);
                queue.add(w);
            }
        }
    }
    
    return discovered;
}
```

큐를 이용한 BFS 와 스택을 이용한 DFS 의 차이는 무엇일까?

스택은 늦게 들어간 순서로 추출이 되고, 큐는 빨리 들어간 순서로 추출이 된다.

그래서 스택을 이용하면 깊이를 우선하게 된다. 계속 그 길로 파게 되니까

큐를 이용하면 들어간 것부터 처리가 되니까, 내 근처에 있는 것들을 미리 처리한다.
그리고 그들의 연관관계에 있는 노드들은 큐에 쌓여있는 채로 뒤늦게 처리된다.

말로 표현하니까 설명이 어렵다.

```
1 -> 2, 3, 4

     2 -> 5

     3 -> 5

          5 -> 6, 7

```

이렇게 그래프가 있다고 보자.

스택에 쌓는 걸 상상해보자

1이 먼저 쌓이고, 1을 빼서 처리한다.

2, 3, 4 가 스택에 쌓인다.

그럼 4가 뽑힌다.

4에 대해서 근처 노드들을 처리하고

이젠 3 차례다.

3 근처 노드들을 다 처리한다. 3, 5, 6, 7

그리고 2 차례다.

시작 노드의 바로 근처 노드들의 깊이대로 스택에 쌓인다.

반면 큐를 보자.

1이 큐에 쌓이고 1을 빼서 처리한다.

그럼 큐에는 2, 3, 4 가 차례로 쌓인다.

2를 빼서 처리하고, 큐에는 2 근처 노드인 5, 6, 7 이 쌓인다.

이때 큐에서 빠지는 건? 3이다. 

시작 노드 근처 노드들부터 큐에 쌓이고 빠진다.

이 원리를 잘 기억하자.


