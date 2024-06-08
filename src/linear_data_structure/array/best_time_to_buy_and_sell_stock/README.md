# 주식을 사고팔기 가장 좋은 시점

> prices = [8, 1, 5, 3, 6, 4]
> 
> maxProfit = 5
> 
> 한 번의 거래로 낼 수 있는 최대 이익을 산출하라.

위 예시를 보면, 우리는 1에서 사고 6에서 팔면 5라는 최대 수익을 나타낼 수 있다는 것을 알 수 있다.

가장 흔하게는, 브루트포스를 활용해서 풀 수 있겠다.
하지만 타임아웃이 발생할 것이 뻔하고, 풀이가 간단하기에 따로 기재하지는 않겠다.

우리는 저점을 기록하고, 그 저점과 현재 값의 차이를 계산해 profit 을 계산해나가며, maxProfit 을 구할 것이다.

```java
int minPrice = 0;
for (int price : prices) minPrice = Math.min(minPrice, price);
```

모든 값을 돌면서, 저점을 구하는 코드이다.

초기 저점은 첫 번째 값으로 임시 세팅해두고, 각 배열의 요소를 순환하면서 현재가격과 현재저점을 비교해 저점을 기록한다.

profit 은 아래와 같이 구할 수 있다. 현재가격과 현재저점의 차이를 구하는 것이다.
```java
int profit = price - minPrice;
```


```java
int maxProfit(int[] prices) {
    int maxProfit = 0, minPrice = prices[0];
    
    for (int price : prices) {
        minPrice = Math.min(price, minPrice);
        int profit = price - minPrice;
        maxProfit = Math.max(maxProfit, profit);
    }
    
    return maxProfit;
}
```
