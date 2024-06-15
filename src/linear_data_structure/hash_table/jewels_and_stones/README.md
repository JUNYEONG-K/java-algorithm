#  보석과 돌

> J는 보석이며, S는 갖고 있는 돌이다. S에는 보석이 몇 개나 들어 있을까?
> 
> J = "aA", S = "aAABCNE" => 3개 (a 1개, A 2개)

`Map 자료구조`에 글자와 개수를 저장해두고, 개수를 합하자.

```java
import java.util.HashMap;
import java.util.Map;

int numJewelsInStones(String J, String S) {
    Map<Character, Integer> map = new HashMap<>();

    for (char c : S.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

    int result = 0;
    for (char c : J.toCharArray()) if (map.containsKey(c)) result += map.get(c);
    
    return result;
}
```
