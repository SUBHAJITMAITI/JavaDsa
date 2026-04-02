//✅ Time Complexity = O(N)
//Space Complexity = O(H)
//H = height of BST (best = logN, worst = N)
public class BST_to_greater_sum_tree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static int sum = 0;

    public static void greaterSum(Node root2) {
        if (root2 == null) {
            return;
        }
        greaterSum(root2.right);
        int copy = root2.data;
        root2.data = sum;
        sum += copy;
        greaterSum(root2.left);

    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Node root2 = new Node(10);
        root2.left = new Node(6);
        root2.right = new Node(15);
        root2.left.left = new Node(3);
        root2.left.right = new Node(8);
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);
        greaterSum(root2);
        preorder(root2);
    }
}
