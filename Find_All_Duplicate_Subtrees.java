//Time Complexity: O(n)
//Space Complexity: O(n)
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_All_Duplicate_Subtrees {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Map<String, Integer> tripletToId = new HashMap<>();
    public static Map<Integer, Integer> count = new HashMap<>();
    static List<Node> result = new ArrayList<>();
    static int id = 1;

    private static int Find_duplicate(Node root) {
        if (root == null) {
            return 0;
        }
        int left = Find_duplicate(root.left);
        int right = Find_duplicate(root.right);

        // Serialization of subtree
        String key = root.data + "," + left + "," + right;

        // Assign unique ID if not seen before
        int uid = tripletToId.computeIfAbsent(key, x -> id++);

        // Count frequency
        count.put(uid, count.getOrDefault(uid, 0) + 1);

        // If duplicate found second time, add to result
        if (count.get(uid) == 2) {
            result.add(root);
        }

        return uid;
    }

    // Helper to print a subtree (preorder format)
    private static void printSubtree(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");

        printSubtree(root.left);
        printSubtree(root.right);

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(4);
        root.right = new Node(3);
        root.left.left = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        root.right.left.left = new Node(3);

        Find_duplicate(root);

        System.out.println("Duplicate Subtrees:");
        for (Node n : result) {
            printSubtree(n);
            System.out.println();
        }
    }
}
