//Time Complexity: O(N · L)
//Space Complexity: O(N · L)

import java.util.ArrayList;

public class Group_Anagrams_Together {
    public static class Node {
        Node[] Children = new Node[26];
        ArrayList<String> al = new ArrayList<>();

        Node() {
            for (int i = 0; i < Children.length; i++) {
                Children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c - 'a']++;
        }
        Node curr = root;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                if (curr.Children[i] == null) {
                    curr.Children[i] = new Node();
                }
                curr = curr.Children[i];
            }

        }
        curr.al.add(s);

    }

    public static void result(Node root, ArrayList<ArrayList<String>> a) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.Children[i] != null) {
                if (!root.Children[i].al.isEmpty()) {
                    a.add(root.Children[i].al);
                }
                result(root.Children[i], a);
            }
        }

    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        // String[] strs = {"a"};
        // String[] strs = {""};
        for (int i = 0; i < strs.length; i++) {
            insert(strs[i]);
        }
        ArrayList<ArrayList<String>> a = new ArrayList<>();
        result(root, a);
        System.out.println(a);

    }
}
