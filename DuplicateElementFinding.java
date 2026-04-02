//time complexity -O(n^2)
//space complexity -O(1)
public class DuplicateElementFinding {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 3, 4, 5 };
        int n = arr.length;
        // time complexity -O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Duplicate Elements : " + arr[i]);
                }
            }
        }

    }
}
