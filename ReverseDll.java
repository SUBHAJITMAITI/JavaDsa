public class ReverseDll {
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

    public void reverse() {
        Node temp = head;
        Node prev = null;
        Node next;
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            temp.prev = next;
            prev = temp;
            temp = next;
        }
        head = prev;
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
        ReverseDll Dll = new ReverseDll();
        Dll.addlast(1);
        Dll.addlast(2);
        Dll.addlast(3);
        Dll.addlast(4);
        Dll.addlast(5);
        print();
        Dll.reverse();
        print();
    }
}
