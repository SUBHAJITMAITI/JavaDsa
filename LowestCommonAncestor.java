
//Time complexity :O(n)
//space complexity :O(n)
import java.util.ArrayList;

public class LowestCommonAncestor {
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

    // approach : 1
    public static boolean getPath(Node root, int n1, ArrayList<Node> path) { // Time complexity :O(n)
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.data == n1) {
            return true;
        }
        boolean foundleft = getPath(root.left, n1, path);
        boolean foundright = getPath(root.right, n1, path);
        if (foundleft || foundright) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2) { // Time complexity :O(n)
        ArrayList<Node> path1 = new ArrayList<>();// space complexity :O(n)
        ArrayList<Node> path2 = new ArrayList<>();// space complexity :O(n)

        getPath(root, n1, path1);// Time complexity :O(n)
        getPath(root, n2, path2);// Time complexity :O(n)
        int i = 0;
        //last common ancestor
        for (; i < path1.size() && i < path2.size(); i++) { // Time complexity :O(n)
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        return path1.get(i - 1);
    }

    // another approach : 2
    public static Node lca1(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftnode = lca1(root.left, n1, n2);
        Node rightnode = lca1(root.right, n1, n2);
        //leftLCA=val rightLca=null
        if (leftnode == null) {
            return rightnode;
        }
        if (rightnode == null) {
            return leftnode;
        }
        return root;

    }

    public static void main(String[] args) {
        /*
         *     1
         *    /  \
         *   2    3
         *  / \  / \
         * 4   5 6  7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int n1 = 4, n2 = 5;
        System.out.println(lca(root, n1, n2).data);
        System.out.println(lca1(root, n1, n2).data);
    }
}
