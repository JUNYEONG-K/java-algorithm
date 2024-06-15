# 상위 k 빈도 엘리먼트 (Top K Frequent Elements)

> 빈도순으로 k 개의 엘리먼트를 추출하라.

빈도 `순서`로 `k개` 를 추출하라 라는 문구에서 우리는 `우선순위 큐 자료구조` 를 떠올릴 수 있다.

`Map 자료구조`에 값과 빈도수를 기록하고, 빈도수 역순을 기준으로 우선순위 큐에 저장하자.

그리고 큐에서 k 번만큼만 poll 하면 끝이다.

```java
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    for (int num : nums)
        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    
    for (int element : frequencyMap.keySet())
        pq.add(new int[]{element, frequencyMap.get(element)});
    
    int[] result = new int[k];
    for (int i = 0; i < k; i++) result[i] = pq.poll()[0];
    
    return result;
}
```
