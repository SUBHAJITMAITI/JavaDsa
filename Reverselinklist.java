public class Reverselinklist {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
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

    public void reverse() {    //   TC = O(n)
        Node prev = null;
        Node temp = tail = head;
        Node next;
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        head = prev;
    }

    public static void main(String[] args) {
        Reverselinklist ll = new Reverselinklist();
        ll.Add(1);
        ll.Add(2);
        ll.Add(3);
        ll.Add(4);
        ll.Add(5);
        ll.Add(6);
        ll.Add(7);
        ll.print();
        ll.reverse();
        ll.print();
    }

}