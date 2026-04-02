//Time: O(N · H) (worst), O(N) (average)
//Space: O(H)
//Best case (balanced tree): O(log N)
//Worst case (skewed tree): O(N)
import java.util.ArrayList;

public class RootToLeafPath {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node nodeInsert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (root.data > val) {
            // left subtree
            root.left = nodeInsert(root.left, val);
        } else {
            // right subtree
            root.right = nodeInsert(root.right, val);
        }
        return root;
    }

    public static Node findPath(ArrayList<Integer> a, Node root) {
        if (root == null) {
            return root;
        }
        a.add(root.data);
        Node left = findPath(a, root.left);
        Node right = findPath(a, root.right);
        if (left == null && right == null) {
            for (int i = 0; i < a.size(); i++) {
                System.out.print(a.get(i) + "-> ");
            }
            System.out.println("null");
        }
        a.remove(a.size() - 1);
        return root;
    }

    public static void findPath1(ArrayList<Integer> a, Node root) {
        if (root == null) {
            return;
        }
        a.add(root.data);
        if (root.left == null && root.right == null) {
            for (int i = 0; i < a.size(); i++) {
                System.out.print(a.get(i) + "-> ");
            }
            System.out.println("null");
        }

        findPath(a, root.left);
        findPath(a, root.right);
        a.remove(a.size() - 1);

    }

    public static void main(String[] args) {
        int vlaues[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < vlaues.length; i++) {
            root = nodeInsert(root, vlaues[i]);
        }
        ArrayList<Integer> a = new ArrayList<>();
        findPath(a, root);
        findPath1(a, root);
    }
}
