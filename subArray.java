public class subArray {

    // brute force

    public static void printSubArrays(int[] numbers) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int tc = 0;
        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                currentSum = 0;

                for (int k = start; k <= end; k++) {
                    currentSum = currentSum + numbers[k];
                }

                tc++;
                if (maxSum < currentSum) {
                    maxSum = currentSum;
                }
            }
            // System.out.println();
        }
        System.out.println("total subArray count : "+tc );
        System.out.println(" highest max value of sub array sum :" + maxSum);
    }

    // optimal
    // public static void subAr(int arr[]){
    // int MS=Integer.MIN_VALUE;
    // int CM=0;
    // for(int i=0;i<arr.length;i++){
    // CM=CM+arr[i];
    // MS=Math.max(CM,MS);

    // }

    // System.out.println(MS);
    // }

    public static void main(String[] args) {

        int[] arr = { 2, 4, 6, 8, 10 };
        printSubArrays(arr);
        // subAr(arr);

    }
}
