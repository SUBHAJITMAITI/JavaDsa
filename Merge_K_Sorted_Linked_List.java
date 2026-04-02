//Time: O(Nlogk)
//Space: O(k)

import java.util.PriorityQueue;

public class Merge_K_Sorted_Linked_List {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node mergeKList(Node list[], int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        for (int i = 0; i < k; i++) {
            pq.add(list[i]);
        }
        Node dummy = new Node(0);
        Node tail = dummy;
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            tail.next = curr;
            tail = tail.next;
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }
        return dummy.next;
    }

    // Helper function to print a linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Node[] list = new Node[3];
        list[0] = new Node(1);
        list[0].next = new Node(3);
        list[0].next.next = new Node(7);
        list[1] = new Node(2);
        list[1].next = new Node(4);
        list[1].next.next = new Node(8);
        list[2] = new Node(9);
        list[2].next = new Node(10);
        list[2].next.next = new Node(11);
        Node result = mergeKList(list, 3);
        printList(result);
    }
}
