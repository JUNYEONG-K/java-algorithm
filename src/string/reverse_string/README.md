# 문자 배열 뒤집기

입력으로 들어온 문자 배열을 뒤집으면 된다.

다만, 새로운 배열을 반환하는 것은 아니고, 기존의 배열을 조작하는 것이다.

```java
void reverseArray(char[] s) {
    int start = 0;
    int end = s.length - 1;
    
    while (start < end) { // 서로 중앙으로 이동해 나가다, 겹치는 지점에 도달하면 종료
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        
        start++; end--;
    }
}
```

함수의 인자인 `s` 는 배열의 참조값을 가지고 있다. 따라서 배열의 참조에 직접 조작을 하면, 원본 배열이 조작된다.
