# 팰린드롬

> 팰린드롬: 앞뒤가 똑같은 단어나 문장으로, 뒤집어도 같은 말이 되는 단어 또는 문장을 가리킨다.

1. 문자 단위로 추출해서 처리

`String` 래퍼 클래스의 `charAt` 메서드를 통해 `char 원시 자료형`을 꺼내서 얘네를 비교하자.

원시 자료형을 활용한 비교는 속도에 우위를 점한다.

* 앞에서 뒤로 1칸씩, 뒤에서 앞으로 1칸씩 다가온다.
* 영숫자만을 대상으로 하기에, 영숫자가 아니면 건너뛴다. (`Character.isLetterOrDigit()`)
* 만약 중간에 일치하지 않는다면, 즉시 false 를 리턴하며 종료한다. 어차피 팰린드롬이 아니기 때문이다.
* 앞에서부터 시작한 것과, 뒤에서부터 다가온 것이 중간에서 만나서도 문제 없다면 true 를 반환한다.

```java
boolean isPalindrome(String s) {
    int start = 0;
    int end = s.length() - 1;
    
    while (start < end) { // 서로 중앙으로 이동해 나가다, 겹치는 지점에 도달하면 종료
        if (!Character.isLetterOrDigit(s.charAt(start))) start++;
        if (!Character.isLetterOrDigit(s.charAt(end))) end--;
        if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) return false;
        
        start++; end--;
    }
} 
```


2. 문자열 직접 비교

직접 문자열을 비교해볼 수 있다.

문자열은 `String 객체` 이기에, equals 를 활용할 수 있다. (`String 클래스` 내부에서 `equals` 메서드를 재정의해두었다. 객체의 참조값 비교가 아닌, 문자열 비교로)

***다만 객체를 직접 비교하기 때문에, 원시 자료형을 비교하는 방법에 비해선 속도가 느리다.***

* 유효한 문자만 추출해서 소문자로 변경한다. (정규식을 활용)
* 위에서 추출한 문자열을 뒤집은 문자열을 하나 더 만든다. (`StringBuilder.reverse().toString()`)
* equals 메서드를 활용해 둘을 비교한다.

```java
boolean isPalindrome(String s) {
    String origin = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    String reversed = new StringBuilder(origin).reverse().toString();
    return origin.equals(reversed);
}
```

1번 풀이에 비해서 코드가 간결하다는 장점은 있다.
