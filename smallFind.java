public class smallFind {
    public static boolean compare(String s, String u) {
        if (u.compareTo(s) < 0) {
            return true;
        }
        return false;
    }

    public static void find(String[] arr, int n) {
        if (n < 0) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            // String t = arr[i];

            if (compare(arr[i], arr[i + 1])) {
                String temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;

            }
        }
        find(arr, n - 1);
    }

    public static void main(String[] args) {
        String[] arr = { "subha", "amit", "khokan", "suarajit", "sovan" };
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();
        find(arr, arr.length);
        for (String s : arr) {
            System.out.print(s + " ");
        }
        // System.out.println(arr.clone());
    }
}
