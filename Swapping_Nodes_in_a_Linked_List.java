//   Time Complexity  : o(n)
//   Space Complexity: o(1)
public class Swapping_Nodes_in_a_Linked_List {
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

    public static void swap(int x, int y) {
        if (x == y) {
            return;
        }
        Node prevX = null;
        Node currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }
        Node prevY = null;
        Node currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        if (currX == null || currY == null) {
            return;
        }
        if (prevX != null) {
            prevX.next = currY;
        } else {
            head = currY;
        }

        if (prevY != null) {
            prevY.next = currX;
        } else {
            head = currX;
        }

        Node temp1 = currX.next;
        currX.next = currY.next;
        currY.next = temp1;

    }

    public static void main(String[] args) {
        Swapping_Nodes_in_a_Linked_List ll = new Swapping_Nodes_in_a_Linked_List();
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
        print();
        swap(6, 1);
        print();
    }
}
