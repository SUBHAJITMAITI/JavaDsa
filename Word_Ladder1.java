
//Time Complexity = O(N * M)
//Space Complexity =O(N * M)
import java.util.*;
import java.util.LinkedList;

public class Word_Ladder1 {
    public static int shortestChainLen(String start, String target, Set<String> D) {

        if (start.equals(target)) {
            return 0;
        }
        if (!D.contains(target)) {
            return 0;
        }
        int wordLength = start.length();

        int level = 0;
        Queue<String> q = new LinkedList<>();

        q.add(start);

        HashMap<String, String> hm = new HashMap<>();

        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String st = q.remove();
                char[] s = st.toCharArray();

                for (int j = 0; j < wordLength; j++) {
                    char curr = s[j];

                    for (char c = 'A'; c <= 'Z'; c++) {
                        if (c == curr) {
                            continue; // skip same char
                        }
                        s[j] = c;
                        String value = String.valueOf(s);
                        if (target.equals(value)) {
                            hm.put(value, st);
                            List<String> path = new ArrayList<>();
                            String str = value;
                            while (str != start) {
                                path.add(str);
                              
                                str = hm.get(str);
                            }
                            path.add(start);
                            Collections.reverse(path);
                            System.out.println("Transformation Path: " + String.join(" -> ", path));
                            return level + 1;
                        }
                        if (!D.contains(value)) {
                            continue;
                        }

                        D.remove(value);
                        q.add(value);
                        hm.put(value, st);

                    }
                    s[j] = curr;
                }

            }

        }
        return 0;

    }

    public static void main(String[] args) {
        Set<String> D = new HashSet<>();
        D.add("HIT");
        D.add("HOT");
        D.add("DOT");
        D.add("DOG");
        D.add("COG");
        D.add("LOG");

        String start = "HIT";
        String target = "COG";

        System.out.println("Length of shortest chain is: " +
                shortestChainLen(start, target, D));
       

    }
}
