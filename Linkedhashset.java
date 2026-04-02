import java.util.*;

public class Linkedhashset {
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
        lhs.remove("Delhi");
        System.out.println(lhs);

        //we can perform all the operation such we done in hashset
    }
}
