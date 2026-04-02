//Time Complexity  : o(n)
//Space Complexity: o(1)
public class Delete_N_Nodes_After_M_Nodes_of_a_Linked_List {
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

    public static void Delete_N_Nodes_After_M_Nodes(Node head, int m, int n) {
        Node temp = head;
        while (temp != null) {
            for (int i = 1; i < m && temp != null; i++) {
                temp = temp.next;
                if (temp == null) {
                    return;
                }
            }
            Node temp1 = temp.next;
            for (int j = 1; j <= n && temp1 != null; j++) {
                temp1 = temp1.next;
            }
            temp.next = temp1;
            temp = temp1;
        }
    }

    public static void main(String[] args) {
        Delete_N_Nodes_After_M_Nodes_of_a_Linked_List ll = new Delete_N_Nodes_After_M_Nodes_of_a_Linked_List();
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

        Delete_N_Nodes_After_M_Nodes(head, 3, 2);
        print();
    }
}
