//Note time complexity and space complexity from chatgtp in your copy

import java.util.HashMap;

public class LRUcache {

    // Doubly linked list node class
     static class Node {
        int key;    // Key of the cache entry
        int value;  // Value of the cache entry
        Node prev;  // Pointer to previous node
        Node next;  // Pointer to next node

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LRUCache {
        private int capacity;               // Maximum number of items in cache
        private HashMap<Integer, Node> map; // Map for O(1) access: key -> node
        private Node head;                  // Dummy head node (Most Recently Used side)
        private Node tail;                  // Dummy tail node (Least Recently Used side)

        // Constructor to initialize LRU Cache
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.head = new Node(0, 0); // Dummy head
            this.tail = new Node(0, 0); // Dummy tail
            head.next = tail;
            tail.prev = head;
        }

        // Get value of a key if present, else return -1
        public int get(int key) {
            if (!map.containsKey(key)) return -1; // Key not found

            Node node = map.get(key);
            moveToHead(node); // Move accessed node to head (MRU)
            return node.value;
        }

        // Add a key-value pair or update an existing key
        public void put(int key, int value) {
            if (map.containsKey(key)) {
                // Key exists: update value and move node to head
                Node node = map.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                // Key does not exist: create new node
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                addToHead(newNode); // Insert at head (MRU)

                // If cache exceeds capacity, remove LRU node
                if (map.size() > capacity) {
                    Node tailNode = removeTail(); // Remove LRU node
                    map.remove(tailNode.key);     // Remove from map
                }
            }
        }

        // Add a node right after the dummy head (MRU side)
        private void addToHead(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        // Remove a node from the doubly linked list
        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Move a node to head (mark as Most Recently Used)
        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        // Remove the tail node (Least Recently Used)
        private Node removeTail() {
            Node node = tail.prev;
            removeNode(node);
            return node;
        }
    }

    // Test the LRU Cache
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2); // Capacity = 2

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
