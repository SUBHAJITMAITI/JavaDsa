//Time: O(N) (each node visited once).
//Space: O(N) (queue + hashmap).

import java.util.LinkedList;
import java.util.*;

public class BottomViewOfTree1 {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class info {
        int bal;
        Node node;

        info(Node node, int bal) {
            this.bal = bal;
            this.node = node;
        }
    }

    public static void bottomview(Node root) {
        HashMap<Integer, Node> hm = new HashMap<>();

        Queue<info> q = new LinkedList<>();
        q.add(new info(root, 0));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            info curr = q.poll();
            hm.put(curr.bal, curr.node);
            if (curr.node.left != null) {

                q.add(new info(curr.node.left, curr.bal - 1));
                min = Math.min(min, curr.bal - 1);
            }
            if (curr.node.right != null) {

                q.add(new info(curr.node.right, curr.bal + 1));
                max = Math.max(max, curr.bal + 1);
            }

        }

        for (int i = min; i <= max; i++) {
            System.out.print(hm.get(i).data + " ");
        }
    }

    public static void main(String[] args) {
      
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);

        root.left.left = new Node(5);
        root.left.right = new Node(3);

        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        root.right.right = new Node(25);

        bottomview(root);
    }
}
