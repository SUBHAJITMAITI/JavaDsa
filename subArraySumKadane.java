public class subArraySumKadane {
    public static void printSubArraysum(int[] numbers) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            currentSum = currentSum + numbers[i];
            if (currentSum < 0) {
                currentSum = 0;
            }

            if (maxSum < currentSum) {
                maxSum = currentSum;
            }
        }
        System.out.println(maxSum);
    }

    public static void main(String[] args) {
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        printSubArraysum(arr);

    }
}
