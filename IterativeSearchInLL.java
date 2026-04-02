
public class IterativeSearchInLL {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

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

    public void print() { // tc = O(n)
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

    public int itrser(int key) { // TC = O(n)
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) { // key found
                return i;
            }
            i++;
            temp = temp.next;
        }
        // key not found
        return -1;
    }

    public int recser(Node ptr, int key, int i) {
        if (ptr == null) {
            return -1;
        }
        if (ptr.data == key) {
            return i;
        }
        return recser(ptr.next, key, i + 1);
    }

    // another way

    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int recser1(int key) {
        return helper(head, key);
    }

    // public static void change(Node ptr) {
    // ptr.data = 99;
    // }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void main(String[] args) {
        IterativeSearchInLL ll = new IterativeSearchInLL();
        ll.Add(3);
        ll.Add(2);
        ll.Add(1);

        ll.Add(4);
        ll.Add(5);
        ll.Add(6);
        ll.Add(7);
        ll.print();
        System.out.println(ll.itrser(10));
        System.out.println(ll.itrser(4));
        System.out.println(ll.recser(head, 4, 0));
        System.out.println(ll.recser(head, 10, 0));
        // ll.change(head);
        // System.out.println(head.data);
        // ll.print();
        System.out.println(ll.recser1(4));
        System.out.println(ll.recser1(10));
        ll.print();
    }
}
