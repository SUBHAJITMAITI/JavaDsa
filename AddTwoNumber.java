public class AddTwoNumber {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static void main(String[] args) {
        // l1 = [2,4,3], l2 = [5,6,4]
        Node root = new Node(2);
        root.next = new Node(4);
        root.next.next = new Node(3);

        Node root1 = new Node(5);
        root1.next = new Node(6);
        root1.next.next = new Node(4);
        Node dummy = new Node(-1);
        Node head = dummy;
        int carry = 0;
        while (root != null || root1 != null || carry != 0) {
            int total = carry;
            if (root != null) {
                total += root.data;
                root = root.next;
            }
            if (root1 != null) {
                total += root1.data;
                root1 = root1.next;
            }
            carry = total / 10;
            head.next = new Node(total % 10);
            head = head.next;

        }
        Node root3 = dummy.next;
        while (root3 != null) {
            System.out.print(root3.data + " ");
            root3 = root3.next;
        }
    }
}