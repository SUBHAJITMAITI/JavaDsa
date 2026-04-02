//Time complexity : O(n)
//space Complexity: O(h) (worst case O(n), best case O(log n))
//where h = height of the tree.
public class TranceformToSumTree {
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

    public static int sumTree(Node root) {
        if (root == null) {
            return 0;
        }
        int l = sumTree(root.left);
        int r = sumTree(root.right);
        // int j = root.data;
        // if (l == 0 && r == 0) {
        // root.data = 0;
        // return j;
        // } else {
        // root.data = l + r;
        // return l + r + j;
        // }
        int oldvalue = root.data;
        int newvalue = l + r;
        root.data = newvalue;
        return oldvalue + newvalue;

    }

    // Another Approach
    public static int sumTree1(Node root) {
        if (root == null) {
            return 0;
        }
        int leftChild = sumTree1(root.left);
        int rightChild = sumTree1(root.right);
        int data = root.data;
        int newleft = root.left == null ? 0 : root.left.data;
        int newright = root.right == null ? 0 : root.right.data;
        root.data = leftChild + newleft + rightChild + newright;
        return data;

    }

    public static void preorder(Node root) { // O(n)
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);

    }

    public static void main(String[] args) {
        /*
         *    1
         *   / \
         *  2   3
         * / \ / \
         * 4 5 6 7
         */
        // expected sum tree is :
        /*
         *    27
         *   / \
         *  9  13
         * / \ / \
         * 0 0 0 0
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // sumTree(root);
        sumTree1(root);
        preorder(root);
    }
}
