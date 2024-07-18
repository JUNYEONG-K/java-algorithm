# 회전 정렬된 배열 검색
> 특정 피벗을 기준으로 회전하여 정렬된 배열에서 target 값의 인덱스를 출력하라.
> 
> nums = [3, 4, 5, 6, 0, 1, 2], target = 1
> 
> 5

우선 피벗을 먼저 찾아야 한다.
그래야 제대로 정렬된 배열을 우리가 알 수 있다.

가장 작은 값을 찾는다면, 그게 곧 피벗이 될 것 같다.

```java
int left = 0, right = nums.length - 1;
while (left <= right) {
    int mid = left + (right - left) / 2;
    
    if (nums[mid] > nums[right]) left = mid + 1;
    else right = mid;
}
int pivot = left;
```
최솟값을 찾는 방식도 이진 검색으로 구현했다. 근데 이해가 안되는 방식이다. `TODO`

어쨋든, 이제는 이진 검색으로 값을 찾아보자.

```java
int left = 0, right = nums.length - 1;
while (left <= right) {
    int mid = left + (right - left) / 2;
    int midPivot = ...
        
    if (nums[mid] < target) left = mid + 1;
    else if (nums[mid] > target) right = mide - 1;
    else return mid;
}
```

위 코드는 반복을 활용한 이진 검색이다.
`midPivot` 이라는 놈이 좀 중요하다.

`int midPivot = (mid + pivot) % nums.length;`

`midPivot`은 중앙의 위치 mid 에서 pivot 만큼 이동하고, 배열의 길이를 초과할 경우 모듈러 연산으로 회전할 수 있도록 처리했다.
이제 target 값과 비교하는 부분은 mid 가 아닌 midPivot 을 기준으로 하되, left 와 right 는 mid 를 기준으로 이동한다.

```java
public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
        int mid = left + (right - left) / 2;
        
        if (nums[mid] > nums[right]) left = mid + 1;
        else right = mid;
    }
    int pivot = left;
    
    left = 0;
    right = nums.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        int midPivot = (mid + pivot) % nums.length;
        
        if (nums[midPivot] < target) left = mid + 1;
        else if (nums[midPivot] > target) right = mid - 1;
        else return midPivot;
    }
    return -1;
}
```
정리하자면 위와 같은데, 어렵다. `TODO`
