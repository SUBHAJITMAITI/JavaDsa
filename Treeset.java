import java.util.*;

public class Treeset {
    public static void main(String[] args) {
        HashSet<String> h = new HashSet<>();
        h.add("Delhi");
        h.add("Mumbai");
        h.add("Noida");
        h.add("Bengaluru");
        System.out.println(h);

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Noida");
        lhs.add("Bengaluru");
        System.out.println(lhs);

        TreeSet<String> ts = new TreeSet<>();
        ts.add("Delhi");
        ts.add("Mumbai");
        ts.add("Noida");
        ts.add("Bengaluru");
        System.out.println(ts);

         //we can perform all the operation such we done in hashset
    }
}
