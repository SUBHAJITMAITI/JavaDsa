import java.util.*;

public class Monotonic {
    public static boolean isMonotonic(ArrayList<Integer> list) {
        int n = list.size();
        boolean ace = true;
        boolean dec = true;
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                ace = false;
            }
            if (list.get(i) < list.get(i + 1)) {
                dec = false;
            }
        }
        return ace || dec;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(3);

        System.out.println(isMonotonic(list));
    }
}
