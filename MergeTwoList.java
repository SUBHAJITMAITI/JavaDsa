public class MergeTwoList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    // another way
    public static Node merge1(Node h1, Node h2) {
        if (h1 == null || h2 == null) {
            return h1 == null ? h2 : h1;
        }
        Node tail = new Node(-1);
        Node temp = tail;
        while (h1 != null && h2 != null) {
            if (h1.data <= h2.data) {
                tail.next = h1;
                tail = h1;
                h1 = h1.next;
            } else {
                tail.next = h2;
                tail = h2;
                h2 = h2.next;
            }
        }
        if (h1 != null) {
            tail.next = h1;
        } else {
            tail.next = h2;
        }
        return temp.next;
    }

    public static Node merge(Node h1, Node h2) {
        if (h1 == null || h2 == null) {
            return h1 == null ? h2 : h1;
        }
        if (h1.data <= h2.data) {
            h1.next = merge(h1.next, h2);
            return h1;
        } else {
            h2.next = merge(h1, h2.next);
            return h2;
        }
    }

    public static void print() { // tc = O(n)
        if (head == null) {
            System.out.println("linklist is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");

    }

    public static void main(String[] args) {
        Node arr[] = new Node[2];
        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);
        head = merge(arr[0], arr[1]);
        print();
        // head = merge1(arr[0], arr[1]);
        // print();
    }
}
