import java.util.*;

public class containsduplicate {

    public static boolean containsDuplicate(int[] arr) {
        // brust forse
        int n = arr.length;
        boolean k = false;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    k = true;
                    break;
                }
            }
        }
        return k;
    }
    // optimal

    public static boolean contains(int[] arr) {
        HashSet<Integer> list = new HashSet<>();
        boolean k = false;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (list.contains(arr[i])) {
                k = true;
                break;
            } else {
                list.add(arr[i]);
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3,  4, 5, 6, 7 };
        System.out.println(containsDuplicate(arr));
        System.out.println(contains(arr));
    }
}
