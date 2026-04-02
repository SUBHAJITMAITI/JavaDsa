//Insertion:
//Time = O(log N) (balanced height)
//Space = O(log N) (recursion stack)
//Preorder Traversal:
//Time = O(N)
//Space = O(log N)
//Overall AVL Tree Space (storage): O(N)

public class AVLtree {
    // Node structure
    static class Node {
        int data, height;
        Node left, right;

        Node(int d) {
            data = d;
            height = 1; // new node height = 1
        }
    }

    Node root;

    // Utility function to get height
    int height(Node n) {
        if (n == null)
            return 0;
        return n.height;
    }

    // Utility function to get balance factor
    int getBalance(Node n) {
        if (n == null)
            return 0;
        return height(n.left) - height(n.right);
    }

    // Right rotate
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left rotate
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Insert node in AVL
    Node insert(Node node, int key) {
        // 1. Normal BST insert
        if (node == null)
            return new Node(key);

        if (key < node.data)
            node.left = insert(node.left, key);
        else if (key > node.data)
            node.right = insert(node.right, key);
        else // duplicate not allowed
            return node;

        // 2. Update height
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // 3. Get balance factor
        int balance = getBalance(node);

        // 4. Balance the tree
        // Left Left Case
        if (balance > 1 && key < node.left.data)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.data)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node; // unchanged
    }

    // Preorder traversal
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Main function
    public static void main(String[] args) {
        AVLtree tree = new AVLtree();

        /* Insert nodes */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        // Preorder Traversal (Root, Left, Right)
        System.out.println("Preorder traversal of AVL tree:");
        tree.preOrder(tree.root);
    }
}
