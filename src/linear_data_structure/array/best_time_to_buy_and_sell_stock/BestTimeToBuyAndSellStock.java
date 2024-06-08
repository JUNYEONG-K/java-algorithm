package linear_data_structure.array.best_time_to_buy_and_sell_stock;

public class BestTimeToBuyAndSellStock {
    static int maxProfitByBruteForce(int[] nums) {
        int maxProfit = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                maxProfit = Math.max(maxProfit, nums[j] - nums[i]);
            }
        }
        return maxProfit;
    }

    static int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = prices[0];

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{8, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println("maxProfit = " + maxProfit);
    }
}
