# 그룹 애너그램

> 애너그램: 일종의 언어유희로, 문자를 재배열하여 다른 뜻을 가진 단어로 바꾸는 것을 말한다.

애너그램을 판단하는 가장 간단한 방법은 문자열을 정렬하여 비교하는 것이다.

정렬된 문자열을 키값으로 가지는 `Map 자료구조`를 활용해 애너그램을 묶을 수 있다.

값으로는 배열을 받아, 애너그램에 속하는 문자열들을 기록한다.

이외에는 어려울 것이 없다.

1. 애너그램을 묶어 기록할 Map 을 선언한다. (키: 정렬된 문자열, 값: 기록할 문자열 배열)

```java
import java.util.*;

List<List<String>> groupAnagrams(String[] strings) {
    Map<String, List<String>> results = new HashMap<>();

    for (String string : strings) {
        char[] charArray = string.toCharArray();
        Arrays.sort(charArray);

        String key = String.valueOf(charArray);
        if (!results.containsKey(key)) results.put(key, new ArrayList<>());
        results.get(key).add(string);
    }
    
    return new ArrayList<>(results.values());
}
```
