# 세 수의 합

> nums = [-1, 0, 1, 2, -1, -5]
> 
> 배열을 입력받아 합으로 0을 만들 수 있는 3개의 엘리먼트를 출력하라.
> 
> [[-1, 0, 1], [-1, -1, 2]]


1. 브루트 포스 (Brute Force)

우리가 가장 쉽게 떠올릴 수 있는 건 역시나 브루트 포스이다.

전체 배열을 뒤져가며, 합이 0이 되는 순간을 찾으면 된다.

```java
nums[i] + nums[j] + nums[k] == 0
```

우리가 한 가지 조심해야할 것은 nums[i], nums[j], nums[k] 는 각각 중복되면 안된다는 것이다.

무슨 의미냐면, nums[i]에 -1이 들어갔었다면, 또 nums[i]에 -1이 들어가는 경우는 배제해야 한다는 것이다.

이를 간단하게 검증하기 위해, nums 배열을 정렬한 후, 이전값과 동일하면 건너 뛰는 방식으로 체크하겠다.

```java
Arrays.sort(nums);
for (int i = 0; i < nums.length; i++) {
    if (i > 0 && nums[i] == nums[i-1]) continue;
}
```

nums 를 배열하면 [-5, -1, -1, 0, 1, 2] 이다.

만약 위 검증 없이 Brute Force 로 조회한다면, nums[i] 가 -1 인 케이스가 2번 나올 것이다.

`(2번째 -1, 0, 1), (3번쨰 -1, 0, 1)`

전체 소스 코드는 아래와 같다.

```java
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

List<List<Integer>> threeSumByBruteForce(int[] nums) {
    List<List<Integer>> results = new LinkedList<>();
    Arrays.sort(nums);
    
    for (int i = 0; i < nums.length; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        for (int j = i + 1; j < nums.length; j++) {
            if (j > i + 1 && nums[j] == nums[j - 1]) continue;
            for (int k = j + 1; k < nums.length; k++) {
                if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                if (nums[i] + nums[j] + nums[k] == 0)
                    results.add(Arrays.asList(nums[i], nums[j], nums[k]));
            }
        }
    }
    
    return results;
}
```

2. 투 포인터 활용

배열을 정렬하고, 중복되는 케이스는 배제하는 원리는 동일하다.

세 수의 합인데, 어떻게 두개의 포인터로 계산하지?

for 문을 돌면서, i 를 축으로 하여, i+1과 nums 의 맨 마지막을 투포인터의 시작점으로 잡는 것이다.

정렬된 배열을 기준으로, [-5, -1, -1, 0, 1, 2], nums[i] = -5일 때 각 포인터는 -1과 2부터 시작하여 중앙으로 모인다.

nums[i] = -1 일 때, 각 포인터는 -1과 2부터 시작하여 중앙으로 모인다.

nums[i]가 중복되는 케이스는 아래 코드로 배제할 수 있다.

```java
for (int i = 0; i < nums.length; i++) {
    if (i > 0 && nums[i] == nums[i-1]) continue;
}
```

각각의 포인터가 가리키는 값이 중복되는 케이스는 아래 코드로 배제한다.

```java
while (left < right && nums[left] == nums[left+1]) left++;
while (left < right && nums[right] == nums[right-1]) right--;
```
각 포인터가 가리킬 다음 위치를 미리 연산하여, 이전값과 같다면 계산을 생략하는 것이다.

이때 말하는 계산은 `nums[i] + nums[left] + nums[right] == 0` 에 대한 조건식이다.

전체 코드는 아래와 같다.

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

List<List<Integer>> twoSumByTwoPointers(int[] nums) {
    int left, right, sum;
    List<List<Integer>> results = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
        if (i > 0 && nums[i] == nums[i-1]) continue;
        
        left = i + 1; right = nums.length - 1;
        while (left < right) {
            sum = nums[i] + nums[left] + nums[right];

            if (sum < 0) left++;
            if (sum > 0) right--;
            if (sum == 0) {
                results.add(Arrays.asList(nums[i], nums[left], nums[right]));
                while (left < right && nums[left] == nums[left+1]) left++;
                while (left < right && nums[right] == nums[right-1]) right--;
                left++; right--;
            }
        }
    }
    return results;
}
```
