import java.util.*;

public class typeOfMap {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(3, "subha");
        map.put(1, "amit");
        map.put(7, "khokan");
        map.put(5, "surajit");
        System.out.println(" hashmap class map looks like" + map);

        //order of insertion retained in LinkedHashMap
        LinkedHashMap<Integer, String> map1 = new LinkedHashMap<>();
        map1.put(3, "subha");
        map1.put(1, "amit");
        map1.put(7, "khokan");
        map1.put(5, "surajit");
        System.out.println(" LinkedHashMap class map looks like" + map1);

        //sorted output on the basis of the keys
        TreeMap<Integer, String> map2 = new TreeMap<>();
        map2.put(3, "subha");
        map2.put(1, "amit");
        map2.put(7, "khokan");
        map2.put(5, "surajit");
        System.out.println(" TreeMap class map looks like" + map2);

    }
}
