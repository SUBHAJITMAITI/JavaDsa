//Approach : 2

//Time Complexity: O(n)
//Space Complexity: O(h) (O(log n) for balanced tree, O(n) for skewed tree)
public class DiameterOfATree1 {
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

    static class info {
        int dia;
        int height;

        info(int dia, int height) {
            this.dia = dia;
            this.height = height;
        }

    }

    public static info Diameter(Node root) {
        if (root == null) {
            return new info(0, 0);
        }
        info leftinfo = Diameter(root.left);
        info rightinfo = Diameter(root.right);
        int diam = Math.max(Math.max(leftinfo.dia, rightinfo.dia), leftinfo.height + rightinfo.height + 1);
        int height = Math.max(leftinfo.height, rightinfo.height) + 1;
        return new info(diam, height);  
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
        System.out.println(Diameter(root).dia);
        System.out.println(Diameter(root).height);
    }
}
