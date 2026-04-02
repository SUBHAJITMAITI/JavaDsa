
//time complexity - O(N)
//space complexity - O(N)
import java.util.*;

public class firstOccurence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String : ");
        String s = sc.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        // construction of a hashtable
        // key -unique characters in the string
        // value -frequency of each character in the string

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        // Scan the entire hashtable and get the index of the non-repeating character
        int result = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                result = 1;
                System.out.println("The first non-repeating element is : " + s.charAt(i) + "  and index is : " + i);
                break;
            }
        }
        if (result == -1) {
            System.out.println("no non-repeating character present in the String");
        }

    }
}
