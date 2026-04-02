//Time Complexity: O(min(N, k))
//Space Complexity: O(H)→ O(log N) (best), O(N) (worst). where H is the height of BST.

public class Find_k_th_smallest_element_in_BST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int count = 0;
    static int result = -1;

    public static void findKthSmallest(Node root, int k) {
        if (root == null) {
            return;
        }
        findKthSmallest(root.left, k);
        count++;
        if (count == k) {
            result = root.data;
            return;
        }
        findKthSmallest(root.right, k);
    }

    public static void main(String[] args) {
        Node root = new Node(8); // Root
        root.left = new Node(5); // Left child of 8
        root.right = new Node(11); // Right child of 8

        root.left.left = new Node(3); // Left child of 5
        root.left.right = new Node(6); // Right child of 5

        root.right.right = new Node(20);// Right child of 11
        int k = 5;
        findKthSmallest(root, k);
        System.out.println(result);
    }
}
