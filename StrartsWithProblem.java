public class StrartsWithProblem {
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

    public static boolean startwith(String s) { // O(L) length of prefix
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (curr.Children[idx] == null) {
                return false;
            }
            curr = curr.Children[idx];
        }

        return true;

    }

    public static void main(String[] args) {
        String words[] = { "apple", "app", "mango", "woman" };
        String prefix1 = "app";  //true
        String prefix2 = "moon";  // false
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        System.out.println(startwith(prefix1));
        System.out.println(startwith(prefix2));
    }
}
