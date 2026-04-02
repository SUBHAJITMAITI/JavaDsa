import java.util.*;

public class hashMapFunctions {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();

        // functionlity of put() function
        hashMap.put(1, "sovan");
        hashMap.put(2, "amit");
        hashMap.put(3, "khokan");
        hashMap.put(4, "surajit");
        hashMap.put(5, "subha");
        System.out.println("Hashmap of Given data is : " + hashMap);
        // functionlity of get() function
        String result = hashMap.get(2);
        System.out.println(result);

        // functionlity of containskey() function
        System.out.println(hashMap.containsKey(2));
        // functionlity of remove() function
        hashMap.remove(2);
        System.out.println("updated hashmap  : " + hashMap);

        // functionlity of entryset() function
        // iterating using the for loop
        for(Map.Entry<Integer, String> e : hashMap.entrySet()) {
            System.out.println("Hashmap is : ");
            System.out.println(e.getKey() + " : " + e.getValue());
        }

    }
}
