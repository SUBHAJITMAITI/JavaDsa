public class quickSort {
    public static int quick(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        int j = high;
        do {
            while (i <= high && arr[i] <= pivot) {
                i++;
            }
            while (pivot < arr[j] && j >= low) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        } while (i < j);

        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = quick(arr, low, high);
            sort(arr, low, partition - 1);
            sort(arr, partition + 1, high);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 7, 6, 5, 4, 3, 2, 1 };
        sort(arr, 0, arr.length - 1);
        for (int v : arr) {
            System.out.print(v + " ");
        }
    }
}
