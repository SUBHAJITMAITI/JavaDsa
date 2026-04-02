//Time Complexity: O(N)
//Space Complexity: O(N) (worst case), O(H) (best case for skewed tree)

import java.util.LinkedList;
import java.util.Queue;

public class Find_Minimum_Depth_of_a_Binary_Tree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static Node newNode(int data) {
        Node node = new Node(data);
        node.left = node.right = null;
        return node;
    }

    static class info {
        Node node;
        int dep;

        info(Node node, int dep) {
            this.node = node;
            this.dep = dep;
        }

    }

    public static int FindDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<info> q = new LinkedList<>();
        q.add(new info(root, 1));
        while (!q.isEmpty()) {
            info n = q.remove();
            Node v = n.node;
            if (v.left == null && v.right == null) {
                return n.dep;
            }
            if (v.left != null) {
                q.add(new info(v.left, n.dep + 1));
            }
            if (v.right != null) {
                q.add(new info(v.right, n.dep + 1));
            }

        }

        return 0;

    }

    public static void main(String[] args) {

        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);

        System.out.println(FindDepth(root));
    }
}
