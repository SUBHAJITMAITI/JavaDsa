public class LinkedList4 {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // implementation of inserting at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        // If the Linked List is empty, then make the new node as head
        if (head == null) {
            head = newNode;
            return;
        }
        // linklist is not empty
        // Traverse till the last node
        // newNode.next = null;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return;

    }

    // implementation of inserting at first
    public void insertAtFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

    }

    // implementation of insertion of a node after any node
    public void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;

    }

    // implementation of displaying the linked list
    public void displayLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    static void recursion( Node head){
        Node p=head;
        // if(p==null){
        //     return;
        // }
        if(p!=null){
            recursion(p.next);
            //  System.out.print(p.data+ " ");
            // return;
        }
        // recursion(p.next);
        // System.out.print(p.data +" ");
        
    }

    public static void main(String[] args) {
        LinkedList4 list = new LinkedList4();
        list.insertAtFirst(1);
        list.insertAtEnd(2);
        list.insertAtEnd(4);
        list.insertAtEnd(8);
        System.out.println("before insertion of 10");
        list.displayLL();

        System.out.println("after insertion of 10");
        list.insertAtEnd(10);
     
        list.insertAtFirst(19);
        list.displayLL();
        list.insertAfter(list.head.next.next, 13);
        list.displayLL();
        recursion(list.head);

    }
}
