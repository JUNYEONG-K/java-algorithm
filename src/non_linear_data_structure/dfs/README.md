# DFS 깊이 우선 탐색

깊이 우선 탐색은 `재귀 구조`와 `반복 구조`로 구현할 수 있다.

1. 재귀구조

* 수도 코드

```
DFS(G, v)
    label v as discovered
    for all directed edges from v to w that are in G.adjacentEdges(v) do
        if vertex w is not labeled as discovered then
            recusively call DFS(G, w)
```

이를 자바 코드로 구현하면 아래와 같다.

```java
import java.util.List;

List<Integer> recursiveDFS(int v, List<Integer> discovered) {
    discovered.add(v);
    
    for (Integer w : graph.get(v))
        if (!discovered.contains(w))
            discovered = recursiveDFS(w, discovered);
    
    return discovered;
}
```

중요한 부분은, `discoved.add(v)` 코드 실행 시점이다. 저 시점의 v 에 초점을 두자.

내가 집중해야 하는 부분이다.

2. 스택을 이용한 반복 구조

* 수도 코드

```
DFS(G, v)
    let S be a stack
    S.push(v)
    while S is not empty do
        v = S.pop()
        if v is not labeled as discovered then
            label v as discovered
            for all edges from v to w in G.adjacentEdges(v) do
                S.push(w)
```

이를 자바 코드로 구현하면 아래와 같다.

```java
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

List<Integer> iterativeDFS(int v) {
    List<Integer> discovered = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();
    
    stack.push(v);
    while (!stack.isEmpty()) {
        v = stack.pop();
        if (!discovered.contains(v)) {
            discovered.add(v);
            for (int w : graph.get(v)) {
                stack.push(w);
            }
        }
    }
}
```

이 부분도 역시나 `discovered.add(v)` 부분이 우리가 집중해야할 부분이다.
