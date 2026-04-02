public class DuplicateElementFinding1 {
    public static void main(String[] args) {

        int[] arr = { 0,0, 1,1, 2, 3, 4, 5, 3, 5, 3 };
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int[] arr1 = new int[max +1];
        for (int g = 0; g < max; g++) {
            arr1[g] = 0;
        }
        for (int j = 0; j < arr.length; j++) {
            arr1[arr[j]] = arr1[arr[j]] + 1;
            // System.out.print(arr1[j]+" ");
        }
        System.out.print("Duplicate Element are : ");
        for (int k = 0; k <= max; k++) {
            if (arr1[k] > 1) {
                System.out.print(k + " ");
            }
        }
    }
}
