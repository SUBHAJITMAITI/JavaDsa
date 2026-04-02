//Time Complexity= O(n)

import java.util.HashMap;

public class ValidAnagram {
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        HashMap<Character, Integer> hm1 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hm1.put(s1.charAt(i), hm1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (hm1.get(c) != null) {
                if (hm1.get(c) == 1) {
                    hm1.remove(c);
                } else {
                    hm1.put(c, hm1.get(c) - 1);
                }
            } else {
                return false;
            }
        }
        return hm1.isEmpty();
    }

    public static void main(String[] args) {
        // String s1 = "tulip";
        // String s2 = "lipid";
        String s1 = "race";
        String s2 = "care";
        System.out.println(isAnagram(s1, s2));
    }
}
