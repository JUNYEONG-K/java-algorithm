# 가장 큰 수
> 엘리먼트를 조합해 만들 수 있는 가장 큰 수를 출력하라.
> 
> [3, 30, 34, 8, 9]
> 
> 9834330

정렬 기법을 조금 특이하게 적용해야 한다.
9가 30보다 크다고 판단이 되어야 한다.

9와 30을 비교할 때, 단순히 두 값의 크기를 비교하는 것이 아니라,
930 과 309의 크기를 비교해야 한다.

단순 배열에 대한 삽입 정렬을 진행해보자.

```
i := 1
while i < length(A)
    j := i
    while j > 0 and A[j-1] > A[j]
        swap A[j] and A[j-1]
        j := j - 1
    end while
    i := i + 1
end while
```

```java
import java.util.Arrays;

public boolean toSwap(int n1, int n2) {
    // a + b 와 b + a 를 비교해 후자가 크면 스왑이 필요하므로 true 리턴
    return Long.parseLong(String.valueOf(n1) + n2)
            < Long.parseLong(String.valueOf(n2) + n1);
}

public String largestNumber(int[] nums) {
    int i = 1;
    while (i < nums.length) {
        int j = i;
        while (j > 0 && toSwap(nums[j - 1], nums[j])) {
            int temp = nums[j];
            nums[j] = nums[j - 1];
            nums[j - 1] = temp;
            j--;
        }
        i++;
    }
    if (nums[0] == 0) return "0";
    else return Arrays.toString(nums).replace("\\[|\\]|,|\\s", "");
}
```