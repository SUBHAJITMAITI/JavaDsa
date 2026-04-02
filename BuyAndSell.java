public class BuyAndSell {
    public static void buyAnds(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice; // todays price
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = prices[i];
            }
        }
        System.out.println("total profit is " + maxProfit);
    }

    public static void main(String[] args) {
        int prices[] = { 2, 5, 7, 1, 9 };
        buyAnds(prices);
    }
}
