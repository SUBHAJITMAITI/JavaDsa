public class Best_Time_to_Buy_and_Sell_Stock {
    public static int maxProfit(int prices[]) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else if (maxProfit < (prices[i] - min)) {

                maxProfit = prices[i] - min;
            }
            // min = Math.min(min, prices[i]);
            // maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = { 7, 6, 4, 3, 1 };
        System.out.println(maxProfit(prices1)); // 0

        int[] prices2 = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices2)); // 5
    }
}
