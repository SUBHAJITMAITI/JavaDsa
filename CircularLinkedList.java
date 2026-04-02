public class CircularLinkedList {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node head;
    public static Node tail;

    public static void print() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        Node temp = head.next;
        System.out.print(head.data + "->");

        while (temp != head) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    // AddAtFirst
    public void AddAtFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
          
        }

    }

    // AddAtLast
    public void AddAtLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }

    }

    // removeAtFirst
    public void removeAtFirst() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = tail = null;
            return;
        }

        head = head.next;
        tail.next = head;

    }

    // removeAtLast
    public void removeAtLast() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = tail = null;
            return;
        }
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        tail = temp;
        temp.next = head;
    }

    public static void main(String[] args) {
        CircularLinkedList ll = new CircularLinkedList();
        ll.AddAtFirst(4);
        ll.AddAtFirst(3);
        ll.AddAtFirst(2);
        ll.AddAtFirst(1);
        print();
        ll.AddAtLast(5);
        print();
        ll.removeAtFirst();
        print();
        ll.removeAtLast();
        print();
    }
}
