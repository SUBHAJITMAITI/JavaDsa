// Time complexity -   O(n) 

public class Flatten_a_Doubly_Linked_List1 {
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

    public static Node Flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        while (temp != null) {

            if (temp.child != null) {
                Node next = temp.next;
                temp.next = Flatten(temp.child);
                temp.child = null;
                temp.next.prev = temp;

                while (temp.next != null) {
                    temp = temp.next;
                }
                // Node curr = temp.next;
                // while (curr != null) {
                // temp = temp.next;
                // curr = curr.next;
                // }
                if (next != null) {
                    temp.next = next;
                    next.prev = temp;
                }

            }
            temp = temp.next;
        }
        return head;
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

    public static void main(String[] args) {
   /* 

 1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5
          │
          ▼
Level 2: 6 ⇄ 7 ⇄ 8
              │
              ▼
Level 3:      9 ⇄ 10

*/
        
        head = new Node(1);
        head.prev = null;
        head.child = null;

        Node l2 = new Node(2);
        head.next = l2;
        l2.prev = head;

        // child list for 3: 6->7->8
        Node l6 = new Node(6);
        Node l7 = new Node(7);
        Node l8 = new Node(8);
        l6.next = l7;
        l7.prev = l6;
        l7.next = l8;
        l8.prev = l7;
        l8.next = null;

        // child of 7: 9->10
        Node l9 = new Node(9);
        Node l10 = new Node(10);
        l9.next = l10;
        l10.prev = l9;
        l10.next = null;
        l7.child = l9;

        Node l3 = new Node(3);
        l2.next = l3;
        l3.prev = l2;
        l3.child = l6;

        Node l4 = new Node(4);
        Node l5 = new Node(5);
        l3.next = l4;
        l4.prev = l3;
        l4.next = l5;
        l5.prev = l4;
        l5.next = null;

        Flatten(head);

        print();
    }
}
