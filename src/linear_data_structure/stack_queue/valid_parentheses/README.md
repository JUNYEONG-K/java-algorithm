# 유효한 괄호

대중소 세 종류 괄호로 된 입력값이 유효한지 판별하라.

> []{}() => true, []]{})( => false

문자열을 순회하면서, 열림 기호는 `Stack`에 쌓고, 닫힘 기호를 만나면 `Stack`에서 꺼내서 짝을 이루는지 비교한다.

우선 짝을 생성하기 위해 `Map 자료구조`를 활용할 것이다.

닫힘 기호가 Key 가 되고, 열림 기호가 Value 가 된다.

```java
import java.util.HashMap;
import java.util.Map;

Map<Character, Character> table = new HashMap<>() {{
    put(']', '[');
    put('}', '{');
    put(')', '(');
}};
```

문자열을 순회하면서 열림 기호는 stack 에 쌓고, 닫힘 기호는 비교하는 코드는 아래와 같다.

```java
if (!table.containsKey(s.charAt(i))) stack.push(s.charAt(i));
else if (table.get(s.charAt(i)) != stack.pop()) return false;
```

`if (!table.containsKey(s.charAt(i))) stack.push(s.charAt(i));` => Map 에 키로 저장해둔 닫힘기호가 아니면, 스택에 쌓는다.

`if (table.get(s.charAt(i)) != stack.pop()) return false;` => 닫힘 기호라면, 즉 위 조건에 위배되는 경우, 스택에서 꺼낸 열림 기호와 Map 의 짝이 되는 value 를 비교한다. (Map 의 Key 는 닫힘, Value 는 열림 기호이다.)

이때, stack 이 비어있을 수 있다.

예를 들어, 맨 처음에 닫힘 기호가 나오거나, 닫힘 기호가 연달아 두번 나오는 등, 스택이 비어있는 상태에서 닫힘 기호를 마주하면, `else if` 문에서 `stack.pop()` 메서드에 오류를 뱉을 것이다.

따라서 `stack.isEmpty()` 조건을 추가해주자. 스택이 비어있는 상태에서 닫힘 기호를 마주하면, 마찬가지로 return false 이다.

```java
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

boolean isValid(String s) {
    Map<Character, Character> table = new HashMap<>() {{
        put(']', '[');
        put('}', '{');
        put(')', '(');
    }};

    Deque<Character> stack = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
        if (!table.containsKey(s.charAt(i))) stack.push(s.charAt(i));
        else if (stack.isEmpty() || stack.pop() != table.get(s.charAt(i))) return false;
    }

    return stack.isEmpty();
}
```

반환을 `stack.isEmpty()` 로 하는 이유는, 유효한 문자열이라면 스택이 비어있어야 하기 때문이다.

만약 문자열의 끝에 열림 기호가 추가로 있었다면 스택에 비어있지 않기 때문이다.
