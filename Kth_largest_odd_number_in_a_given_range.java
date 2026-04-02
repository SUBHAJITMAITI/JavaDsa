//Time Complexity → O(1)
//Space Complexity → O(1)
public class Kth_largest_odd_number_in_a_given_range {
    public static int kthLargestOdd(int L, int R, int K) {

        int largestOdd = (R % 2 != 0) ? R : R - 1;
        int totalOdds = (R - L) / 2 + 1;
        if (totalOdds < K) {
            return 0;
        }
        if (L % 2 == 0 && R % 2 == 0) {
            totalOdds = (R - L) / 2;
        }
        return largestOdd - (K - 1) * 2;

    }

    public static void main(String[] args) {

        int L = -3, R = 3, K = 1;
        System.out.println(kthLargestOdd(L, R, K));
    }
}
