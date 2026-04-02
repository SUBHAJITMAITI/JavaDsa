//Time Complexity: O(N × L)
//Space Complexity: O(N × L)

public class LongestWordWithAllPrefixes {
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

    public static String ans = "";

    public static void LongestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.Children[i] != null && root.Children[i].eow == true) {
                char c = (char) (i + 'a');
                temp.append(c);
                if (ans.length() < temp.length()) {
                    ans = temp.toString();
                }
                LongestWord(root.Children[i], temp);
                temp.deleteCharAt(temp.length() - 1); // backtrack

            }
        }

    }

    public static void main(String[] args) {
        String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        LongestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
