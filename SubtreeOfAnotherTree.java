//m = number of nodes in subRoot
//n = number of nodes in root
//Time Complexity: O(n × m)

//IsSubtree: depth up to height of main tree = O(h1).
//IsIdentical: depth up to height of sub tree = O(h2).
//Space Complexity: O(h1 + h2)
public class SubtreeOfAnotherTree {
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

    public static boolean IsIdentical(Node root, Node subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null || subRoot.data != root.data) {
            return false;
        }
        if (!IsIdentical(root.left, subRoot.left)) {
            return false;
        }
        if (!IsIdentical(root.right, subRoot.right)) {
            return false;
        }

        return true;
    }

    public static boolean IsSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (IsIdentical(root, subRoot)) {
                return true;
            }
        }

        return IsSubtree(root.left, subRoot) || IsSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        /*
         *   1
         *  / \
         * 2   3
         * /\  /\
         * 4 5 6 7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        /*
         * 2
         * / \
         * 4 5
         */
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(IsSubtree(root, subRoot));
    }
}
