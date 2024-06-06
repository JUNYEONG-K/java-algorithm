# 로그 파일 재정렬

1. 로그의 가장 앞부분은 식별자로서, 순서에 영향을 끼치지 않는다.
2. 문자로 구성된 로그가 숫자 로그보다 앞에 오며, 문자로그는 사전순으로 정렬한다.
3. 문자가 동일한 경우에는 식별자순으로 한다.
4. 숫자 로그는 입력 순서대로 한다.

> {"id1 8 1 5 1", "id2 art can", "id3 3 6", "id4 own kit dig", "id5 art zero"}

로그는 위와 같은 형태로 구성된다.

문자 로그와 숫자로그는 정렬 기준이 아예 다르며, 문자 로그 묶음을 앞에, 숫자 로그 묶음을 뒤에 두어야 한다.

따라서 이들은 별도로 분류해서 다루겠다.

```java
List<String> letterList = new ArrayList<>();
List<String> digitList = new ArrayList<>();
```

문자 로그의 경우, 식별자를 제외한 부분을 가지고 비교를 해서 정렬을 해야한다.

식별자와 나머지 부분을 분리하기 위해, 아래와 같이 코드를 작성할 수 있다.

```java
String log = "id2 art can";
String[] result = log.split(" ", 2);

// => result: [id2, art can]
```

1. 문자 로그와 숫자 로그를 분리한다.
2. 문자 로그는 사전순, 같다면 식별자 순으로 비교한다. (`String.split(" ", 2) => 식별자와 나머지 분리` & `String.compareTo`)
3. 숫자 로그 묶음은 문자 로그 묶음 뒤에 붙인다. (`ArrayList.addAll()`)

```java
import java.util.ArrayList;
import java.util.List;

String[] reorderLogFiles(String[] logs) {
    List<String> letterLogs = new ArrayList<>();
    List<String> digitLogs = new ArrayList<>();

    for (String log : logs) {
        if (Character.isDigit(log.charAt(0))) digitLogs.add(log);
        if (Character.isLetter(log.charAt(0))) letterLogs.add(log);
    }

    letterLogs.sort((s1, s2) -> {
        String[] s1x = s1.split(" ", 2);
        String s1index = s1x[0];
        String s1string = s1x[1];
        
        String[] s2x = s2.split(" ", 2);
        String s2index = s2x[0];
        String s2string = s2x[1];
        
        return s1string.compareTo(s2string) == 0 ? s1index.compareTo(s2index) : s1string.compareTo(s2string);
    });
    
    letterLogs.addAll(digitLogs);
    return letterLogs.toArray(new String[0]);
}
```
