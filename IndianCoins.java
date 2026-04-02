
//Time Complexity = O(n log n + k) ≈ O(k) (since n is very small for Indian coins)
//Space Complexity = O(n + k)
//👉 In practice, it behaves like O(k) time, where k = number of coins needed.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoins {
    public static void main(String[] args) {
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        Arrays.sort(coins, Comparator.reverseOrder());
        ArrayList<Integer> a = new ArrayList<>();
        int countOfCoins = 0;
        int amount = 590;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    a.add(coins[i]);
                    countOfCoins++;
                    amount -= coins[i];
                }
            }
        }
        System.out.println("total (min) coins used = " + countOfCoins);
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + " ");
        }

    }
}
