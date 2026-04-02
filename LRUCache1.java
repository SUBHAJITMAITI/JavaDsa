import java.util.HashMap;

public class LRUCache1 {
    static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> hm;
    private Node head, tail;

    LRUCache1(int capacity) {
        this.capacity = capacity;
        hm = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!hm.containsKey(key)) {
            return -1;
        }
        Node node = hm.get(key);
        MoveAthead(node);
        return node.val;

    }

    public void put(int key, int val) {

        if (hm.containsKey(key)) {
            Node node = hm.get(key);
            node.val = val;
            MoveAthead(node);
        } else {
            Node node = new Node(key, val);
            MoveAtFirst(node);
            hm.put(key, node);

            if (hm.size() > capacity) {
                Node node1 = tailnode();
                hm.remove(node1.key);
            }
        }

    }

    private void MoveAtFirst(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;

    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void MoveAthead(Node node) {
        remove(node);
        MoveAtFirst(node);

    }

    private Node tailnode() {
        Node node = tail.prev;
        remove(node);

        return node;
    }

    public static void main(String[] args) {
        LRUCache1 cache = new LRUCache1(2); // Capacity = 2

        cache.put(1, 1); // cache = {1=1}
        cache.put(2, 2); // cache = {2=2,1=1} (MRU → LRU)
        System.out.println(cache.get(1)); // returns 1 → cache = {1=1,2=2}

        cache.put(3, 3); // evicts key 2 → cache = {3=3,1=1}
        System.out.println(cache.get(2)); // returns -1 (not found)

        cache.put(4, 4); // evicts key 1 → cache = {4=4,3=3}
        System.out.println(cache.get(1)); // returns -1
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4

    }
}
