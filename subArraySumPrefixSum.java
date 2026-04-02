public class subArraySumPrefixSum {
    public static void printSubArrays(int[] numbers) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = Integer.MIN_VALUE;
        int[] prefix = new int[numbers.length];
        prefix[0] = numbers[0];
        // calculate prefix array
        for (int i = 1; i < numbers.length; i++) {
            prefix[i] = prefix[i - 1] + numbers[i];
        }

        for (int i = 1; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                currentSum = i == 0 ? prefix[end] : prefix[end] - prefix[start - 1];

                if (maxSum < currentSum) {
                    maxSum = currentSum;
                }
            }
            // System.out.println();
        }

        System.out.println(" highest max value of sub array sum : " + maxSum);
    }

    public static void main(String[] args) {

        int[] arr = { 1, -2, 6, -1, 3 };
        printSubArrays(arr);
        // subAr(arr);
    }
}