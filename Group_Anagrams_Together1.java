// Time Complexity: O(n∗klogk)
// Space Complexity:O(n∗k)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Group_Anagrams_Together1 {
    public static HashMap<String, ArrayList<String>> hm = new  HashMap<>();

    public static void find(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String d = new String(arr);
        if (hm.containsKey(d)) {
            hm.get(d).add(s);
        } else {
            ArrayList<String> list = new ArrayList<>();
            list.add(s);
            hm.put(d, list);
        }
    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

        for (int i = 0; i < strs.length; i++) {
            find(strs[i]);
        }
        ArrayList<ArrayList<String>> al = new ArrayList<>(hm.values());
        // for (Map.Entry<String, ArrayList<String>> e : hm.entrySet()) {
        // al.add(e.getValue());
        // }
        
        // System.out.println(new ArrayList<>(hm.values()));
        System.out.println(al);
    }
}
