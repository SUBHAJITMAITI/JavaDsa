
import java.util.Arrays;

public class anagrams {
    public static void ana(String s1, String s2) {
        // Convert Strings to lowercase. Why? so that we don't have to checkseparately
        // for lower & uppercase
        s1.toLowerCase();
        s2.toLowerCase();
        // First check - if the lengths are the same
          // convert strings into char array
          char[] d = s1.toCharArray();
          char[] d1 = s2.toCharArray();
        if (s1.length() == s2.length()) {
          
            // sort the char array
            Arrays.sort(d);
            Arrays.sort(d1);
            // if the sorted char arrays are same or identical then the strings are anagram
            if (Arrays.equals(d, d1)) {
                System.out.println(d + " and " + d1 + " are anagrams of eachother.");
            } else {
                System.out.println(d + " and " + d1 + " are not anagrams of each other.");
            }

        }
        // case when lengths are not equal
        else {
            System.out.println(d + " and " + d1 + " are not anagrams of each other.");
        }

    }

    public static void main(String[] args) {
        String s1 = "subha";
        String s2 = "ahbus";
        ana(s1, s2);
    }
}
