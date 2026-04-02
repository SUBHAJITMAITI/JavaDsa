//Time: O(N) (each node visited once).
//Space: O(N) (queue + hashmap).
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class BottomViewOfATree {
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

    public static class info {
        Node node;
        int hd;

        info(Node node, int hd) {
            this.node = node;
            this.hd = hd;

        }
    }

    public static void BottomView(Node root) {
        HashMap<Integer, Node> h = new HashMap<>();
        Queue<info> q = new LinkedList<>();
        q.add(new info(root, 0));
        int min = 0;
        int max = 0;

        while (!q.isEmpty()) {
            info curr = q.remove();

            h.put(curr.hd, curr.node);

            if (curr.node.left != null) {
                q.add(new info(curr.node.left, curr.hd - 1));
                min = Math.min(min, curr.hd - 1);

            }
            if (curr.node.right != null) {
                q.add(new info(curr.node.right, curr.hd + 1));
                max = Math.max(max, curr.hd + 1);
            }

        }

        for (int i = min; i <= max; i++) {
            System.out.print(h.get(i).data + " ");
        }

    }

    public static void main(String[] args) {
/*      1
       / \
      2   3
       \
        4
         \
          5
           \
            6
 */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
        BottomView(root);
    }
}
