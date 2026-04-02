//time complexity - O(n)
public class buyAndSellStocks {

    public static int BuyAndSell(int[] price) {
        int maxProfit = 0;
        int buystocks = Integer.MAX_VALUE;

        for (int i = 0; i < price.length; i++) {
            if (buystocks < price[i]) { // profit
                int profit = price[i] - buystocks;// today's profit
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buystocks = price[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {

        int price[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(BuyAndSell(price));
    }
}
