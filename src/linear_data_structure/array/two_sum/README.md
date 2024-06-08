# 두 수의 합

> nums = [2, 6, 11, 15], target = 8
> 
> nums 의 요소 중, 두 개를 더해서 target 이 되는 값의 index 를 구하라!
> 
> result = [0, 1], 즉 2 + 6 = 8


사실 간단한 문제다. nums 배열을 삥삥 돌면서 target 이 되는 index 배열을 반환하면 된다.
브루트 포스 방식이다.
```java
int[] twoSumByBruteForce(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) return new int[]{i, j};
        }
    }
    return null;
}
```

(2, 6), (2, 11), (2, 15), (6, 11), (6, 15), (11, 15)의 조합을 모두 살펴보는 방법이다.

시간 복잡도는 O(n^2)로 매우 비효율적이다.

이를 `Map 자료구조`를 활용해서 풀이할 수 있다.

우리가 알고자 하는 것은, index 이기에, index 를 value 로 저장하는 `Map` 이 필요하다. 키값은, nums의 값

`x + y = target` 일 때, target 과 x 를 알면 y 를 쉽게 구할 수 있다.

> target - x = y

우리는 `Map 자료구조, 특히 HashMap`의 조회 성능(O(1)을 활용해서, y를 찾을 것이다.

1. nums 의 값을 키로, index 를 value 로 가지는 Map 자료구조 => `map.put(nums[i], i)`
2. `target - nums[i]` 를 map 이 키로써 가지고 있다면, 즉, x 와 y 가 모두 map 의 키로써 존재한다면 그 둘의 index 가 정답이다. => `map.containsKey(target - nums[i])`
3. 다만 이때, 자기 자신을 가리키는 순간은 걸러야 한다. 즉, `target - nums[i]` 가 키 값으로 존재하지만, 그 인덱스가 i 와 같다면 조건을 만족하지 않는 것이다. => `i != map.get(target - nums[i])`
4. 정답은 ! `new int[i, map.get(target - nums[i])]`

```java
import java.util.HashMap;
import java.util.Map;

int[] twoSumByMap(int[] nums, int target) {
    Map<Integer, Integer> numsIndexMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        numsIndexMap.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
        if (numsIndexMap.containsKey(target - nums[i]) && i != numsIndexMap.get(target - nums[i]))
            return new int[]{i, numsIndexMap.get(target - nums[i])};
    }
    
    return null;
}
```
for 문이 결론적으론 2번 돈다. O(n)의 시간복잡도를 가지긴 하지만, 사실 O(2n)이다.

for 문을 하나로 합쳐보자.

```java
import java.util.HashMap;
import java.util.Map;

int[] twoSumByMap(int[] nums, int target) {
    Map<Integer, Integer> numsIndexMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
        if (numsIndexMap.containsKey(target - nums[i]) && i != numsIndexMap.get(target - nums[i]))
            return new int[]{i, numsIndexMap.get(target - nums[i])};
        numsIndexMap.put(nums[i], i);
    }
    
    return null;
}
```
일단 map 에서 찾아보고, 없으면 map 에 넣는 것이다.
