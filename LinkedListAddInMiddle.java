public class LinkedListAddInMiddle {
   class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void Addfirst(int data) { // tc = O(1)
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // Node temp = head;
        newNode.next = head;
        head = newNode;
    }

    public void Addlast(int data) { // tc = O(1)
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

    public void addInMiddle(int index, int data) { // tc = O(n)

        if (index == 0) {
            Addfirst(data);
            return;
        }
        Node newNode = new Node(data);

        size++;

        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static Node head;
    public static Node tail;
    public static int size;

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
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListAddInMiddle ll = new LinkedListAddInMiddle();
        ll.Addfirst(3);
        ll.Addfirst(2);
        ll.Addfirst(1);
        ll.print();
        ll.Addlast(4);
        ll.Addlast(5);
        ll.Addlast(6);
        ll.Addlast(7);
        ll.print();
        ll.addInMiddle(0, 99);
        ll.print();
        System.out.println(ll.size);
    }
}
