public class ZigZagInLL1 {
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

    public static void zigzag() {
        // find mid
        Node slow = head;
        Node first = head.next;
        while (first != null && first.next != null) {
            slow = slow.next;
            first = first.next.next;
        }

        Node mid = slow;
        Node rightHead = mid.next;
        mid.next = null;

        // helf reverse

        Node curr = rightHead;
        Node next;
        Node prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        rightHead = prev;
        Node leftHead = head;
        Node leftnx;
        Node rightnx;
        // alt merge -  zig-zag merge
        while (leftHead != null && rightHead != null) {
            leftnx = leftHead.next;
            leftHead.next = rightHead;
            rightnx = rightHead.next;
            rightHead.next = leftnx;

            leftHead = leftnx;
            rightHead = rightnx;

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
        ZigZagInLL1 ll = new ZigZagInLL1();

        ll.Add(1);
        ll.Add(2);
        ll.Add(3);
        ll.Add(4);
        ll.Add(5);
        print();
        zigzag();
        print();
    }
}
