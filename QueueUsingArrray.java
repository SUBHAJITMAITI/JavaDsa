public class QueueUsingArrray {
    public static class Queue {
        static int arr[];
        static int size;
        static int rear;

        public Queue(int n) {
            this.arr = new int[n];
            this.size = n;
            this.rear = -1;

        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        // add -O(1)

        public static void add(int data) {
            if (rear == size - 1) {
                System.out.println("queue is full");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        // remove -O(n)

        public static int remove() {
            if (isEmpty()) {
                System.out.println("queueu is empty");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

        // peeks -O(1)

        public static int peek() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return arr[0];
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
    }
}
