# 가장 흔한 단어

문장에 등장하는 단어 중, 가장 흔하게 등장하는 단어를 찾는 것이다.

다만 금지된 단어로 설정된 단어들은 제외해야 한다.

> paragraph = "Ross hit a ball, the hit BALL flew far away after it was hit."
> 
> banned = ["hit"]
> 
> most common = "ball"

`Map 자료구조`를 활용해서, 단어별로 등장 횟수를 기록하는 것이 좋겠다.

또한 Map 의 키값으로 단어를 넣을 땐, 단어에 붙은 특수문자(마침표, 쉼표 등)를 제거해서 넣어야 한다.

`hit.` 와 `hit` 는 동일하게 `hit` 라는 키값으로 카운팅 되어야 한다.

1. 데이터 클렌징 (입력값 전처리) => 정규식 활용
2. Map 자료구조에 등장 횟수 기록 (키: 단어, 값: 횟수)
3. 값을 기준으로, max 단어 찾기

```java
import java.util.*;

String mostCommonWord(String p, String[] banned) {
    Set<String> bannedWordsSet = new HashSet<>(Arrays.asList(banned));
    Map<String, Integer> countMap = new HashMap<>();

    String[] words = p.replaceAll("\\W+", " ").toLowerCase().split(" ");

    for (String word : words) {
        if (bannedWordsSet.contains(word)) continue;
        countMap.put(word, countMap.getOrDefault(word, 0) + 1);
    }

    return Collections.max(countMap.entrySet(), Map.Entry.comparingByValue()).getKey();
}
```
