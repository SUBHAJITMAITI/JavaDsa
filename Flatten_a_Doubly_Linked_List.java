// Time complexity -   O(n) 
// Space complexity - O(n) (due to recursion stack)
public class Flatten_a_Doubly_Linked_List {
    public static class Node {
        int data;
        Node next;
        Node prev;
        Node child;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
            this.child = null;
        }

    }

    public static void print() {
        if (head == null) {
            System.out.println("list is empty");
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
    public static Node temp1 = new Node(-1);
    public static Node temp = temp1;

    public static void Flatten(Node head) {
        if (head == null) {
            return;
        }
        temp.next = head;
        head.prev = temp;
        temp = temp.next;

        Node origNext = head.next;
        if (head.child != null) {
            Flatten(head.child);
            head.child = null;
        }
        Flatten(origNext);

    }

    public static void main(String[] args) {

         /* 
        Creating the example list:
        1 -> 2 -> 3 -> 4
             |         |
             7 -> 8    9 -> 10
                 |
                 11 -> 12
        */

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head.next.child = new Node(7);
        head.next.child.next = null;
        head.next.child.child = new Node(8);
        head.next.child.child.child = new Node(11);
        head.next.child.child.child.child = new Node(12);

        head.next.next.child = new Node(9);
        head.next.next.child.child = new Node(10);

        Flatten(head);
        temp.next = null;
        head = temp1.next;
        if (head != null){
            head.prev = null;
        }
        print();
    }
}
