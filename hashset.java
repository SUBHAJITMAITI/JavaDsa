import java.util.*;

public class hashset {
    public static void main(String[] args) {
        HashSet<Integer> h = new HashSet<>();
        h.add(1);
        h.add(2);
        h.add(4);
        h.add(1);
        h.add(2);
        System.out.println(h);
        if (h.contains(2)) {
            System.out.println("set contains 2");
        }
        if (h.contains(3)) {
            System.out.println("set contains 3");
        }


        h.remove(2);
        if (h.contains(2)) {
            System.out.println("set contains 2");
        }

        System.out.println(h.size());
        System.out.println(h.isEmpty());

        h.clear();
        System.out.println(h.isEmpty());
    }
}
