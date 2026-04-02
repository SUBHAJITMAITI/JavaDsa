import java.util.*;

public class extra3 {
    public static Set<List<Integer>> threesum(int[] arr) {
        int n = arr.length;
        Set<List<Integer>> list = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> tt = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int k = -arr[i] - arr[j];
                if (tt.contains(k)) {
                    List<Integer> pp = Arrays.asList(arr[i], arr[j], k);
                    Collections.sort(pp);
                    list.add(pp);
                }
                tt.add(arr[j]);
            }
        }
        return list;
    }

    // public static Set<List<Integer>> threesum(int[] arr) {
    //     int n = arr.length;
    //     Set<List<Integer>> list = new HashSet<>();

    //     for (int i = 0; i < n; i++) {
    //         Set<Integer> tt = new HashSet<>();
    //         for (int j = i + 1; j < n; j++) {
    //             int k = -arr[i] - arr[j];
    //             if (tt.contains(k)) {
    //                 List<Integer> pp = Arrays.asList(arr[i], arr[j], k);
    //                 Collections.sort(pp);
    //                 list.add(pp);
    //             }
    //             tt.add(arr[j]);
    //         }
    //     }
    //     return list;
    // }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, 3, -4 };
        System.out.println(threesum(arr));
    }
}
