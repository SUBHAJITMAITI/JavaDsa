import java.util.LinkedList;
import java.util.Queue;

public class KthLevelOfATree {

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
    // Time Complexity: O(N) (must explore all nodes in worst case).

    // Space Complexity: O(H) (recursion stack, where H = height of tree, worst case
    // O(N) for skewed tree, O(log N) for balanced tree).

    // approach 1
    public static void FindKthLevel(Node root, int k, int n) {
        if (root == null) {
            return;
        }
        if (k == n) {
            System.out.print(root.data + " ");
            return;
        }
        FindKthLevel(root.left, k, n + 1);
        FindKthLevel(root.right, k, n + 1);
    }

    // Time Complexity: O(N)
    // Space Complexity: O(W) (queue size = max width of tree; worst case = O(N) if
    // last level is full).
    // approach 2
    public static class info {
        int level;
        Node node;

        info(int level, Node node) {
            this.level = level;
            this.node = node;
        }
    }

    public static void FindKthLevel1(Node root, int k) {
        Queue<info> q = new LinkedList<>();
        q.add(new info(1, root));
        while (!q.isEmpty()) {
            info curr = q.remove();
            if (curr.level == k) {
                System.out.print(curr.node.data + " ");
            }
            if (curr.node.left != null) {
                q.add(new info(curr.level + 1, curr.node.left));
            }
            if (curr.node.right != null) {
                q.add(new info(curr.level + 1, curr.node.right));
            }
        }
    }

    // modify approach without creating info class
    // Time Complexity: O(N)
    // Space Complexity: O(W) (queue size = max width of tree; worst case = O(N) if
    // last level is full).
    public static void FindKthLevel2(Node root, int k) {
        Queue<Node> q = new LinkedList<>();
        int level = 0;
        q.add(root);
        level++;
        while (!q.isEmpty()) {
            int size = q.size();
            if (level == k) {
                for (int i = 0; i < size; i++) {
                    System.out.print(q.remove().data + " ");
                }
                return;
            }
            for (int i = 0; i < size; i++) {
                Node curr = q.remove();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }

            }
            level++;
        }

    }

    public static void main(String[] args) {
        /*
         * 1
         * / \
         * 2 3
         * /\ /\
         * 4 5 6 7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int k = 3;
        FindKthLevel(root, k, 1);
        System.out.println();
        FindKthLevel1(root, k);
        System.out.println();
        FindKthLevel2(root, k);
    }
}
