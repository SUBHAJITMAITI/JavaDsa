public class Odd_Even_Linked_List {
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

    public static void oddEven() {
        if (head == null || head.next == null) {
            return;
        }
        Node temp = head;

        Node even = new Node(-1);
        Node odd = new Node(-1);
        Node evenHead = even;
        Node oddHead = odd;
        while (temp != null) {

            if (temp.data % 2 == 0) {
                even.next = temp;
                even = even.next;
            } else if (temp.data % 2 != 0) {
                odd.next = temp;
                odd = odd.next;
            }
            temp = temp.next;
        }
        odd.next = null;
        even.next = oddHead.next;
        head = evenHead.next;
    }

    public static void main(String[] args) {
        Odd_Even_Linked_List ll = new Odd_Even_Linked_List();
        ll.Add(1);
        ll.Add(2);
        ll.Add(3);
        ll.Add(4);
        ll.Add(5);
        ll.Add(6);
        ll.Add(7);
        ll.Add(8);
        ll.Add(9);
        ll.Add(10);
        ll.Add(11);
        print();
        oddEven();
        print();
    }
}
