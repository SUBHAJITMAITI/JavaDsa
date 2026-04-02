//time complexity= O(n)
//space complexity= O(1)
public class reversal {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 8, 10 };

        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            //swap the elements between array[i] and array[n-i-1]
            int s = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = s;
        }
        System.out.print("reversal of an array is: ");
        for (int j = 0; j < n; j++) {
            System.out.print(arr[j]+" ");
        }

    }

}
