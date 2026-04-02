import java.util.Arrays;

public class BruteFroceForSliding {
    public static void main(String[] args) {
        int arr[] = { 2, 4, 7, 10, 12, 15, 25, 17 };
        int n=arr.length;
        int k = 3;
        int result[]=new int [n-k+1];
        for (int i = 0; i <n-k+1; i++) {
            int max = 0;
            for (int j = i; j <= k + i - 1; j++) {
                if (max < arr[j]) {
                    max = arr[j];
                }
            }
            result[i]=max;

        }

        System.out.println(Arrays.toString(result));
    }
}
