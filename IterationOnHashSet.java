import java.util.HashSet;
import java.util.Iterator;

public class IterationOnHashSet {
    public static void main(String[] args) {
        HashSet<String> h = new HashSet<>();
        h.add("Delhi");
        h.add("Mumbai");
        h.add("Noida");
        h.add("Bengaluru");

        Iterator it = h.iterator();
        while (it.hasNext()) { // O(n)
            System.out.println(it.next());
        }
        System.out.println();

        for (String city : h) { // O(n)
            System.out.println(city);
        }
    }
}
