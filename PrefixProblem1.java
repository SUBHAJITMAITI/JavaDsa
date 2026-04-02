//Time Complexity: O(N * L)
//Space Complexity: O(N * L) (including recursion O(L))

public class PrefixProblem1 {
    static class Node {
        Node Children[] = new Node[26];
        boolean eow = false;
        int freq;

        Node() {
            for (int i = 0; i < Children.length; i++) {
                Children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) { // O(L)
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.Children[idx] == null) {
                curr.Children[idx] = new Node();
            } else {
                curr.Children[idx].freq++;
            }
            curr = curr.Children[idx];

        }
        curr.eow = true;

    }

    public static String search(String word, String s) { // O(L)
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            s += (char) (idx + 'a');
            if (curr.Children[idx].freq == 1) {
                // System.out.println(s);
                // break;
                return s;
            }

            curr = curr.Children[idx];

        }
        return s;

    }

    public static void main(String[] args) {
        String arr[] = { "zebra", "dog", "duck", "dove" };
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        root.freq = -1;
        for (int i = 0; i < arr.length; i++) {
            String s = search(arr[i], "");
            System.out.println(s);
        }
    }

}
