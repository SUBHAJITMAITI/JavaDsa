public class CountUniqueSubstring {
    static class Node {
        Node Children[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < Children.length; i++) {
                Children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) { // O(L)
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.Children[idx] == null) {
                curr.Children[idx] = new Node();
            }
            curr = curr.Children[idx];

        }
        curr.eow = true;

    }

    public static boolean search(String word) { // O(L)
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.Children[idx] == null) {
                return false;
            }
            curr = curr.Children[idx];

        }
        return curr.eow == true;

    }

    public static int count(Node root) { // O(L)
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if ((root.Children[i] != null)) {
                count += count(root.Children[i]);
            }
        }

        return count + 1;
    }

    public static void main(String[] args) {
        String s = "ababa";
        // String s="apple";
        // suffix -> insert in trie
        for (int i = 0; i < s.length(); i++) {
            String suffix = s.substring(i);
            insert(suffix);
        }
        System.out.println(count(root));
    }
}
