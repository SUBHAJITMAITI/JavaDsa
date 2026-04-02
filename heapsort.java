public class heapsort {
    public static void heapify(int arr[], int i, int n) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int maxidx = i;
        if (left < n && arr[left] > arr[maxidx]) {
            maxidx = left;
        }
        if (right < n && arr[right] > arr[maxidx]) {
            maxidx = right;
        }
        if (maxidx != i) {
            // swap
            int temp = arr[maxidx];
            arr[maxidx] = arr[i];
            arr[i] = temp;

            heapify(arr, maxidx, n);
        }

    }

    public static void heapSort(int arr[]) { // O(n *logn)
        // step1 built -max heap
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) { // O(n/2 *logn)=O(n *logn)
            heapify(arr, i, n);
        }
        // step2 - push the largest at end
        for (int i = n - 1; i >= 0; i--) { // O(n *logn)
            // swap (largest- first with last)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 5, 3 };
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
    }
}
