//Time Complexity: O(N × L)
//Space Complexity: O(N × L)
public class Longest_Word_in_Dictionary {
    public static class Node {
        Node[] Children = new Node[26];
        boolean eow;

        Node() {
            for (int i = 0; i < 26; i++) {
                Children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String s) {
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = (char) (ch - 'a');
            if (curr.Children[idx] == null) {
                curr.Children[idx] = new Node();
            }
            curr = curr.Children[idx];
        }
        curr.eow = true;

    }

    public static StringBuilder s = new StringBuilder("");

    public static void Longest_String(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        if (s.length() < temp.length()) {
            s = new StringBuilder(temp.toString());
        }
        for (int i = 0; i < 26; i++) {

            if (root.Children[i] != null && root.Children[i].eow) {
                temp = temp.append((char) (i + 'a'));

                Longest_String(root.Children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }

        }
    }

    public static void main(String[] args) {
        String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        Longest_String(root, new StringBuilder(""));
        System.out.println(s);

    }
}
