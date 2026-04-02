public class LinkedListAddFirstAndLast {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void Addfirst(int data) {      // tc = O(1)
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // Node temp = head;
        newNode.next = head;
        head = newNode;
    }

    public void Addlast(int data) {       //  tc = O(1)
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // Node temp = head;
        tail.next = newNode;
        tail = newNode;
    }

    public static Node head;
    public static Node tail;

    public void print() {         //           tc = O(n)
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
        LinkedListAddFirstAndLast ll = new LinkedListAddFirstAndLast();
        ll.Addfirst(3);
        ll.Addfirst(2);
        ll.Addfirst(1);
        ll.print();
        ll.Addlast(4);
        ll.Addlast(5);
        ll.Addlast(6);
        ll.Addlast(7);
        ll.print();
    }
}
