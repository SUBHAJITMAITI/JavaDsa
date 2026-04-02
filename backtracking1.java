public class backtracking1 {
    public static void back(int arr[], int n) {
        if (n == arr.length) {
            return;
        }
        arr[n] = n + 1;
        System.out.print(arr[n] + " ");
        back(arr, n + 1);
        arr[n] = arr[n] - 2;
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        back(arr, 0);
        System.out.println();
        for (int e : arr) {
            System.out.print(e + " ");
        }
    }
}
