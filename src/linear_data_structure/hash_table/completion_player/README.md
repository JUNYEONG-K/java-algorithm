# 완주하지 못한 선수

> 마라톤에 참여한 선수 배열과 완주한 선수 배열을 입력 받아, 완주하지 못한 유일한 선수를 출력하라.
> 
> participant = ["leo", "kiki", "eden"], completion = ["eden", "kiki"];
> 
> 출력: "leo"


참여한 선수들의 명단을 보관할 Map 을 선언한다. 

동명이인이 있을 수 있으니, 등장 횟수를 value 로 기록한다.

completion 배열을 순회하면서, participant 를 보관한 Map 에서 키를 제거한다.

남은 마지막 키를 출력한다.

`map.entrySet().iterator().next().getKey()`

```java
import java.util.HashMap;
import java.util.Map;

String solution(String[] participants, String[] completions) {
    Map<String, Integer> pm = new HashMap<>();
    for (String participant : participants)
        pm.put(participant, pm.getOrDefault(participant, 0) + 1);

    for (String completion : completions) {
        int left = pm.get(completion);
        if (left == 1) pm.remove(completion);
        else pm.put(completion, left - 1);
    }
    
    return pm.entrySet().iterator().next().getKey();
}
```
