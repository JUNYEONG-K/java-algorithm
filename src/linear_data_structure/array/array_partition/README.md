# 배열 파티션 I

> nums = [1, 3, 4, 2]
> 
> n개의 페어를 이용한 min(a, b)의 합으로 만들 수 있는 가장 큰 수를 출력하라


(a1,b1) = (1, 3), (a2, b2) = (4, 2) => 1 + 2 = 3

(a1, b1) = (1, 2), (a2, b2) = (3, 4) => 1 + 3 = 4

각각의 요소들은 겹칠 수 없다.

문제의 요구조건을 충족하려면, 각 페어의 min 은 가급적 커야 한다.

최대한 비슷한 애들끼리 pair 로 묶을 때, min 이 가급적 크다.

nums 를 오름차순으로 정렬하고, 순차적으로 2개씩 묶어 pair 를 만들자

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

int arrayPartition(int[] nums) {
    int sum = 0;
    List<Integer> pair = new ArrayList<>();

    for (int num : nums) {
        pair.add(num);
        if (pair.size() == 2) {
            sum += Collections.min(pair);
            pair.clear();
        }
    }
    
    return sum;
}
```

그런데 생각해보면, 배열을 정렬해두면, 홀수번째, 즉 인덱스로 따지면 인덱스의 값이 짝수인 애들이 항상 min 이다.

이 원리를 적용시켜보자.

```java
int arrayPartition(int[] nums) {
    int sum = 0;

    for (int i = 0; i < nums.length; i++) {
        if (i % 2 == 0) sum += nums[i];
    }
    
    return sum;
}
```

훨씬 간단한 풀이가 되었다.
