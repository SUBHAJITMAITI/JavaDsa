import java.util.Arrays;

public class findOnlyNonRepeatingElement2 {
    public static void main(String[] args) {
        int arr[] = { 2, 2, 1, 15, 1, 1, 2 };
        int arr1[] = new int[32];
        for (int i = 0; i < arr.length; i++) {
            int j = 31;
            int n = arr[i];
            while (n > 0) {
                arr1[j] += (n & 1);
                j--;
                n = n >> 1;
            }
        }
        for (int j = 0; j < arr1.length; j++) {
            arr1[j] = arr1[j] % 3;
        }
        System.out.println(Arrays.toString(arr1));
        int res = 0;
        int pow = 0;
        for (int j = arr1.length-1; j >=0; j--) {
            res += Math.pow(2, pow) * arr1[j];
            pow++;
        }
        System.out.println(res);
        

    }
}
