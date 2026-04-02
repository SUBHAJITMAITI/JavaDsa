public class MergesortOnLL1 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void Add(int data) { // tc = O(1)
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // Node temp = head;
        tail.next = newNode;
        tail = newNode;
    }

    public static Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // mid Node
    }

    public static Node merge(Node left, Node right) {
        Node newNode = new Node(-1);
        Node temp = newNode;
        while (left != null && right != null) {
            if (left.data <= right.data) {
                temp.next = left;
                temp = left;
                left = left.next;
            } else {
                temp.next = right;
                temp = right;
                right = right.next;
            }
        }
        while (left != null) {
            temp.next = left;
            temp = left;
            left = left.next;
        }
        while (right != null) {
            temp.next = right;
            temp = right;
            right = right.next;
        }
        return newNode.next;
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

    public static Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // find mid
        Node mid = findMid(head);
        // left && right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node left = sort(head);
        Node right = sort(rightHead);
        // merge
        return merge(left, right);
    }

    public static void main(String[] args) {
        MergesortOnLL1 ll = new MergesortOnLL1();
        // ll.Add(5);
        ll.Add(4);
        ll.Add(3);
        ll.Add(2);
        ll.Add(1);
        head = sort(head);
        print();

        // merge sort time complexsity in linkedlist = O (nlogn)
    }
}
