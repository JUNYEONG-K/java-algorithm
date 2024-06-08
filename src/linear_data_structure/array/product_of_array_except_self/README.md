# 자신을 제외한 배열의 곱

> nums = [1, 3, 4, 7]
> 
> output = [105, 35, 21, 15]
> 
> output[i] 는 nums[i]를 제외한 나머지 nums 요소들의 곱을 나타낸다.

덧셈과 곱셈에서 각각 자신을 제거하는 방법은, 반대로 뺄셈과 나눗셈을 취하는 것이다.

무슨 말이냐면, 1 + 2 + 3 + 4 연산에서 1을 빼고 계산하는 방법은, 2 + 3 + 4 를 연산하는 것이 아니라,
1 + 2 + 3 + 4 - 1 을 계산하는 것이다.

곱셈도 마찬가지이다.

우리는 nums 의 모든 요소에 대한 곱셈 결과를 가지고, output 배열의 각 인덱스에는 결과 / nums[i]를 넣으면 되는 것이다.

```java
int[] productExceptSelf(int[] nums) {
    int p = 1;
    
    for (int num : nums) p *= num;

    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) result[i] = p / nums[i];
    
    return result;
}
```

깔끔하다.

만약 나눗셈을 하지 말라는 조건이 있다면 어떨까?
실제 문제의 조건은 나눗셈을 금지한다.

기준이 되는 인덱스를 기준으로 왼쪽부터 곱셈을 해오고, 이후 다시 오른쪽부터 곱셈을 해오는 것이다.

그렇게 되면 자동으로 자신은 배제된다.

예를 들어, nums 가 [1, 3, 5, 7, 9] 로 되어있었다고 가정하자.

우선 배열의 양 옆에 1을 추가하자.

1, [1, 3, 5, 7, 9], 1
output[i] 에는 output[i-1]까지의 곱을 기록한다.
다시 거꾸로 돌아오면서, output[i+1]까지의 곱을 다시 곱한다.

```java
int[] productExceptSelf(int[] nums) {
    int[] output = new int[nums.length];
    
    int p = 1;
    for (int i = 0; i < nums.length; i++) {
        output[i] = p;
        p *= nums[i];
    }
    
    p = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
        output[i] *= p;
        p *= nums[i];
    }
    
    return output;
}
```
