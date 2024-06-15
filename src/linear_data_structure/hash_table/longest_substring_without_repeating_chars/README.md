# 중복 문자 없는 가장 긴 부분 문자열

> 중복 문자가 없는 가장 긴 부분 문자열의 길이를 리턴하라.
> 
> "abcabcbbc" => 3 (abc | bca | cab)

* 슬라이딩 윈도우와 투 포인터로 크기 조절

투포인터를 활용해 문자열을 조회하여, 시간복잡도를 줄인다.

`right - left + 1` 이 부분 문자열의 길이이다.

이미 있는 문자를 만났다면, left 는 그 문자 위치보다 1칸 앞서 이동한다.

right 는 1칸씩 꾸준히 앞으로 나아간다.

```java
import java.util.HashMap;
import java.util.Map;

int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> used = new HashMap<>();

    int maxLength = 0;
    int left = 0, right = 0;
    for (char c : s.toCharArray()) {
        if (used.containsKey(c) && left <= used.get(c)) left += used.get(c) + 1;
        else maxLength = Math.max(maxLength, right - left + 1);
        
        used.put(c, right);
        right++;
    }
}
```

`left <= used.get(c)` 요 조건이 없으면, left 가 왼쪽 방향으로 이동해버릴 수도 있다.

즉 슬라이딩 윈도우 바깥에 있는 문자까지 가버릴 수도 있다.

해당 조건은 , 우리가 슬라이딩 윈도우 안쪽에 있는 중복 문자에 대해서만 검사를 하겠다는 의미이다.


`if (used.containsKey(c) && left <= used.get(c)) left += used.get(c) + 1;`

아래처럼 바꿀 수도 있다.

```java
if (left <= used.getOrDefault(c, -1)) left += used.get(c) + 1;
```
