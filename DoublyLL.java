public class DoublyLL {
    public class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

    }

    // add first
    public void addfirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            size++;
            head = tail = newNode;
            return;
        }
        size++;
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    // add mid

    public void addmid(int index, int data) {
        Node newNode = new Node(data);
        if (index == 0) {
            addfirst(data);
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        size++;
        Node next = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = next;
        next.prev = newNode;

    }

    // add last
    public void addlast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            size++;
            head = tail = newNode;
            return;
        }
        size++;
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // remove first

    public int removefirst() {
        if (head == null) {
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            size--;
            int val = head.data;
            head = tail = null;
            return val;
        }
        size--;
        int val = head.data;
        head = head.next;
        head.prev = null;
        return val;
    }

    // remove last

    public int removeLast() {
        if (head == null) {
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            size--;
            int val = head.data;
            head = tail = null;
            return val;
        }
        size--;
        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        return val;
    }

    public static void print() { // tc = O(n)
        if (head == null) {
            System.out.println("linklist is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");

    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void main(String[] args) {
        DoublyLL Dll = new DoublyLL();
        Dll.addfirst(5);
        Dll.addfirst(4);
        Dll.addfirst(3);
        Dll.addfirst(2);
        Dll.addfirst(1);

        print();
        System.out.println(size);
        Dll.removefirst();
        System.out.println(Dll.removefirst());
        print();
        // System.out.println(Dll.removefirst());
        // print();
        System.out.println(size);
        System.out.println(Dll.removeLast());
        print();
        Dll.addmid(1, 7);
        print();
        Dll.addlast(99);
        print();
        System.out.println(size);
    }

}