//Time complexity: O(n)
//Space complexity: O(1)

public class Maximum_profit {

    public static int profit(int arr[], int fee) {
        int n = arr.length;
        int buy = -arr[0];
        int sell = 0;
        int mindiffer = Integer.MAX_VALUE;
        int lastBuyDay=0;
        for (int i = 1; i < n; i++) {
            if (sell - arr[i] > buy) {
                buy = sell - arr[i];
                lastBuyDay=i;
            }
            if (buy + arr[i] - fee > sell) {
                sell = buy + arr[i] - fee;
                mindiffer=Math.min(mindiffer,i-lastBuyDay);
            }
        }
        System.out.println(sell);
        return mindiffer;
    }

    public static void main(String[] args) {
        // int arr[] = { 6, 1, 7, 2, 8, 4 };
        // int arr[] = { 10, 15, 17, 20, 16, 18, 22, 20, 22, 20,23,25 };
        int arr[] = {7, 1, 5, 3, 6, 4};
        int transactionFee = 1;
        System.out.println(profit(arr, transactionFee));
    }
}
