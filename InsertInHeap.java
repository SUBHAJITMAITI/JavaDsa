import java.util.ArrayList;

public class InsertInHeap {
    public static class heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) { // O(logn)
            // add at last idx
            arr.add(data);
            int x = arr.size() - 1; // x is child index
            int parent = (x - 1) / 2; // parent index

            while (arr.get(x) < arr.get(parent)) { // O(logn)
                // swap

                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);

                // move upward
                x = parent;
                parent = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            int minidx = i;
            if (left < arr.size() && arr.get(left) < arr.get(minidx)) {
                minidx = left;
            }
            if (right < arr.size() && arr.get(right) < arr.get(minidx)) {
                minidx = right;
            }
            if (minidx != i) {
                // swap
                int temp = arr.get(minidx);
                arr.set(minidx, arr.get(i));
                arr.set(i, temp);
                heapify(minidx);
            }

        }

        public int remove() {
            int data = arr.get(0);
            // step1 - swap first & last
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, data);
            // step2 - delete last
            arr.remove(arr.size() - 1);
            // step3 - heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        heap pq = new heap();

        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(5);
        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }

}
