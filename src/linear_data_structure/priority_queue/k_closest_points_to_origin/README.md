# 원점에서 가장 가까운 k 개의 점

> 평면상에 points 목록이 있을 때, 원점 (0, 0)에서 가장 가까운 k개의 점 목록을 순서대로 출력하라. 평면상에 있는 두 점의 거리는 유클리드 거리로 한다.
> 
> points = [[3, 3], [6, -1], [-2, 4]], k = 2
> 
> 출력: [[3, 3], [-2, 4]]


순서대로 k 개를 출력하라는 부분에서 우리는 우선순위 큐를 활용할 껀덕지를 얻었다.

우선순위 큐에 `distance` 를 미리 계산해서 넣어두고, k 개만 출력하자.

```java
class Point {
    int [] points;
    double distance;
    
    Point(int[] points) {
        this.points = points;
        this.distance = Math.sqrt(points[0] * points[0] + points[1] * points[1]);
    }
}
```
Point 클래스와 생성자를 통해 거리를 클래스 내부에서 계산하자.

```java
PriorityQueue<Point> pq 
        = new PriorityQueue<>(Comparator.comparingDouble(o -> o.distance));
```
pq 에는 Point 객체의 distance 순으로 정렬되어 값이 기록된다.

참고) Java 의 우선순위 큐는 기본적으로 최소 힙이다.

```java
import java.awt.*;
import java.util.Comparator;
import java.util.PriorityQueue;

static class Point {
    int[] points;
    double distance;

    Point(int[] points) {
        this.points = points;
        this.distance = Math.sqrt(points[0] * points[0] + points[1] * points[1]);
    }
}

int[][] kClosest(int[][] points, int k) {
    PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> o.distance));
    
    for (int[] point : points) pq.add(new Point(point));
    
    int[][] results = new int[k][];
    for (int i = 0; i < k; i++) results[i] = pq.poll().points;
    
    return results;
}
```


현재 거리 계산 코드는 아래와 같다.

`Math.sqrt(points[0] * points[0] + points[1] * points[1])`

Math.sqrt 연산이 한 번 더 들어가게 되는데, 굳이? 라는 생각이 든다.

우리는 정확한 값이 아니라, 값의 대소비교를 위한 것 뿐이다. 제곱의 합만 비교를 하면 된다. (어쩌면 두 수의 절대값의 합만으로도 값 비교가 가능할지도 모른다.)

`distance = points[0] * points[0] + points[1] * points[1]` 로 값을 단순화하고, 자료형 또한 `long` 으로 활용할 수 있다.
