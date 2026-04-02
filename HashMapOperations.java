import java.util.HashMap;

public class HashMapOperations {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        // insert- O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        System.out.println(hm);

        // get -O(1)
        int population = hm.get("India");
        System.out.println(population);
        System.out.println(hm.get("Indonesia"));

        // ContainsKey-O(1)
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Indonesia"));

        // remove-O(1)
        // System.out.println(hm.remove("China"));
        System.out.println(hm.remove("Indonesia"));
        System.out.println(hm);

        // size
        System.out.println(hm.size());

        // is Empty
        hm.clear();
        System.out.println(hm.isEmpty());
    }
}
