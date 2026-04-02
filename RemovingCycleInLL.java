public class RemovingCycleInLL {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean IsCycle() { // Floyd's CFA
        Node slow = head;
        Node first = head;
        while (first != null && first.next != null) {
            slow = slow.next; // +1
            first = first.next.next; // +2
            if (slow == first) {
                return true; // cycle exits
            }
        }

        return false; // cycle doesn't exit
    }

    public static void removeCircle() {

        Node slow = head;
        Node first = head;
        boolean cycle = false;
        while (first != null && first.next != null) {
            slow = slow.next; // +1
            first = first.next.next; // +2
            if (slow == first) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }

        slow = head;
        Node prev = null;
        while (slow != first) {

            slow = slow.next;
            prev = first;
            first = first.next;
        }

        prev.next = null;

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
        System.out.print("null");
        System.out.println();
    }

    public static Node head;

    public static void main(String[] args) {
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        System.out.println(IsCycle());
        removeCircle();
        print();
        System.out.println(IsCycle());
    }
}
