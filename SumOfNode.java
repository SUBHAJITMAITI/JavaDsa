//Time complexity : O(n)
public class SumOfNode {
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

    public static int sumofnode = 0;

    public static void sum(Node node) {
        if (node == null) {
            return;
        }
        sumofnode += node.data;
        sum(node.left);
        sum(node.right);
    }

    // Another approach
    public static int sum1(Node node) {
        if (node == null) {
            return 0;
        }
        int leftsum = sum1(node.left);
        int rightsum = sum1(node.right);
        return leftsum + rightsum + node.data;
    }

    public static void main(String[] args) {
        /*
        1
       / \
      2   3
     /   / \
    4   5   6
           /
          7
*/
        // Construct tree manually
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);

        root.right.left = new Node(5);
        root.right.right = new Node(6);

        root.right.right.left = new Node(7);
        sum(root);
        System.out.println(sumofnode);
        System.out.println(sum1(root));
    }
}
