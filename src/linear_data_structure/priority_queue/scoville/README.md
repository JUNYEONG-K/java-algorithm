# 더 맵게

> 모든 음식의 스코빌 지수가 K 이상이 되는 반복 횟수를 구하라.
> 
> scoville = [1, 2, 3, 9, 10, 12], k = 7
> 
> 스코빌 지수 = 가장 맵지 않은 스코빌 지수 + (두 번째로 맵지 않은 스코빌 지수 * 2)

스코빌 지수 배열에서 최소값을 지속해서 꺼내고 계산해야 하기 때문에, 우선순위 큐를 활용해볼 수 있을 것 같다.

스코빌 지수를 우선순위 큐에 모두 넣고, 1번째와 2번째를 꺼내 새로운 스코빌 지수를 계산해서 다시 우선 순위 큐에 넣느다.

만약 `peak()` 값이 k 이상이라면, 멈추고 값을 반환한다.

어렵지 않다.

```java
static int solution(int[] scoville, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
        
    for (int num : scoville) pq.add(num);
        
    int count = 0;
    while (pq.size() >= 2) {
        pq.add(pq.poll() + pq.poll() * 2);
        if (pq.peek() >= k) return count;
        count++;
    }
        
    return -1;
}
```
