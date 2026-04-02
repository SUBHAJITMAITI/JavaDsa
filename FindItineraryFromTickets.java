//Time Complexity: O(n)
//Space Complexity: O(n)

import java.util.HashMap;

public class FindItineraryFromTickets {
    public static String getStart(HashMap<String, String> hm) {
        HashMap<String, String> revMap = new HashMap<>();
        for (String s : hm.keySet()) {
            revMap.put(hm.get(s), s);
        }
        for (String s : hm.keySet()) {
            if (!revMap.containsKey(s)) {
                return s; // Starting point
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("Chennai", "Bengaluru");
        hm.put("Mumbai", "Delhi");
        hm.put("Goa", "Chennai");
        hm.put("Delhi", "Goa");
        String start = getStart(hm);
        System.out.print(start);
        for (String k : hm.keySet()) {
            System.out.print(" -> " + hm.get(start));
            start = hm.get(start);
        }
        System.out.println();
    }
}
