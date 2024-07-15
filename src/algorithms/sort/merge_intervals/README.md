# 구간 병합

> 겹치는 구간을 병합하라
> 
> [[1,3], [8,11], [2, 6], [15, 18]]
> 
> [[1,6], [8,11], [15, 18]]

우선 배열을 정렬하자. 정렬하지 않는다면, 모든 엘리먼트를 순회해야함으로 `O(n^2)` 의 시간복잡도를 가지게 된다.

정렬을 먼저 진행한다면, 정렬에 소요되는 `O(NlogN)` 만큼의 시간복잡도를 가지게 될 수 있다. (이후 비교는 단순 O(n) 시간복잡도를 가질 것이다.)

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public int[] merge(int[][] intervals) {
    ArrayList<int[]> merged = new ArrayList<>();
    // 배열의 첫 번째 값을 기준으로 정렬 (O(NlogN))
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

    for (int[] i : intervals) {
        if (!merged.isEmpty() && i[0] <= merged.getLast()[1]) 
            merged.getLast()[1] = Math.max(merged.getLast()[1], i[1]);
        else merged.add(i);
    }
    
    return merged.toArray(new int[merged.size()][]);
}
```