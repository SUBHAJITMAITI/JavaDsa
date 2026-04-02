//APPROACH : 1
//Time Complexity: O(n²)
//Space Complexity: O(h) (where h = tree height; O(log n) for balanced, O(n) for skewed).

public class DiameterOfATree {
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

    public static int FindHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int l = FindHeight(root.left);
        int m = FindHeight(root.right);
        return Math.max(l, m) + 1;
    }

    public static int Diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDia = Diameter(root.left);
        int leftHeight = FindHeight(root.left);
        int rightDia = Diameter(root.right);
        int rightHeight = FindHeight(root.right);
        int selfDia = leftHeight + rightHeight + 1;
        return Math.max(selfDia, Math.max(leftDia, rightDia));
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
        System.out.println(Diameter(root));
    }
}
