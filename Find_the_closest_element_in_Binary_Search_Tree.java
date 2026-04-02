//Time Complexity = O(h)
//Space Complexity = O(h)
public class Find_the_closest_element_in_Binary_Search_Tree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int min = Integer.MAX_VALUE;
    public static Node root1;

    public static void Find(Node root, int k) {
        if (root == null) {
            return;
        }
        int diff = Math.abs(root.data - k);
        if (min > diff) {
            min = diff;
            root1 = root;
        }
        if (root.data == k) {
            return;
        } else if (root.data < k) {
            Find(root.right, k);
        } else {
            Find(root.left, k);
        }

    }

    //another approach
    public static Node findClosest(Node root, int k) {
        Node closest = root;
        while (root != null) {
            if (Math.abs(root.data - k) < Math.abs(closest.data - k)) {
                closest = root;
            }
            if (root.data == k) {
                break;
            } else if (root.data < k) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return closest;
    }
    public static void main(String[] args) {
        Node root = new Node(8); // Root
        root.left = new Node(5); // Left child of 8
        root.right = new Node(11); // Right child of 8

        root.left.left = new Node(3); // Left child of 5
        root.left.right = new Node(6); // Right child of 5

        root.right.right = new Node(20);// Right child of 11 
       int k=19;
        Find(root, k);
        System.out.println(root1.data + " " +" Min difference : "+ min);
        System.out.println(findClosest(root, k).data);
    }
}
