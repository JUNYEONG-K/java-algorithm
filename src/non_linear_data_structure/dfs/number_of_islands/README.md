# 섬의 개수

> 11110
> 
> 11010
> 
> 11000
> 
> 00001
> 
> 1을 육지로, 0을 물로 가정한 2차원 그리드 맵이 주어졌을 때, 섬의 개수를 계산하라. (연결되어 있는 1의 덩어리 개수를 구하라.)

DFS 를 활용하면 쉽게 풀 수 있다.

DFS 의 자바 코드는 아래와 같았다.

```java
import java.util.List;

List<Integer> recursiveDFS(int v, List<Integer> discovered) {
    // 발견 노드 표시! => 다음 발견 시 무시하도록
    discovered.add(v);

    // 근방의 모든 노드에 대해 순회
    for (Integer w : graph.get(v))
        if (!discovered.contains(w))
            discovered = recursiveDFS(w, discovered);

    return discovered;
}
```

자 DFS 의 핵심은 두 가지이다.

```
1. 발견한 노드를 표시한다. 이를 통해, 미래의 순회에서 다시 발견하였을 때, 이를 무시할 수 있다.
2. 발견한 노드 근방의 모든 노드를 다시 DFS 로 순회한다.
```

이를 통해 섬 개수 구하기의 DFS 전략을 세울 수 있다.

```
1. 발견한 노드를 표시한다. => 1이 아닌 다른 문자열로 수정한다.
2. 발견한 노드 근방의 모든 노드를 다시 DFS 로 순회한다. 동서남북 방향으로 모두 순회한다.
```

```java
void dfs(int i, int j, char[][] grid) {
    // 무시 조건
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
    
    grid[i][j] = '0'; // 발견한 노드를 표시한다. 다음 순회에서 마주치면 무시할 수 있도록!
    
    // 근방의 모든 노드를 순회한다.
    dfs(i, j+1, grid);
    dfs(i, j-1, grid);
    dfs(i+1, j, grid);
    dfs(i-1, j, grid);
}
```

최종 코드는 아래와 같다.

```java
int numIslands(char[][] grid) {
    int count = 0;

    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; i < grid[0].length; i++) {
            if (grid[i][j] == '1') {
                dfs(i, j, grid);
                count++;
            }
        }
    }
    
    return count;
}
```