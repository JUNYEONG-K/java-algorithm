# 일일 온도

매일의 온도 리스트를 입력 받아서, 더 따뜻한 날씨를 위해서는 며칠을 더 기다려야 하는지를 출력하라.

> temperatures = [23, 24, 25, 21, 19, 22, 26, 23];
> 
> output =  [1, 1, 4, 2, 1, 1, 0, 0];

0번째 날은 다음 날 바로 온도가 상승한다. (1일)

반면, 2번째 날은 온도 상승까지 4일이 소요된다. (25 -> 26)

처음 고안한 방법은 역시 `브루트 포스`이다.

모두 순회하면서, 조건을 충족하면 결과를 저장하고 반복문을 break 하는 것이다.

좋지 않은 방법이고, 소스코드 또한 간단하니 따로 기재하지 않겠다.

이건 `Stack 자료구조`를 활용해 풀이할 수 있다.

우리가 현재 궁금한 것은, 온도 상승까지 `며칠` 이 걸리느냐 이다.

이는, `배열의 인덱스 값의 차이`를 통해 구한다.

따라서 우리는 배열의 인덱스를 스택에 쌓아둔다.

스택 Top 인덱스의 온도와 현재 온도를 비교해서, 온도가 상승했다면, 인덱스의 차이만큼을 결과에 저장하고, stack 에서 값은 꺼낸다.

그리고 현재 인덱스는 다시 넣어둔다.

```java
import java.util.ArrayDeque;
import java.util.Deque;

int[] dailyTemperatures(int[] temperatures) {
    int[] result = new int[temperatures.length];
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < temperatures.length; i++) {
        while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
            int last = stack.pop();
            result[last] = i - last;
        }
        stack.push(i);
    }
}
```

`TODO` 한 번에 이해하기 꽤 어려웠다. 다시 해보라하면 떠올리기 힘들 것 같다. 나중에 꼭 다시 보자!
