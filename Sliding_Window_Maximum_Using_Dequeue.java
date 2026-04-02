import java.util.*;
import java.util.LinkedList;

public class Sliding_Window_Maximum_Using_Dequeue {
    // method to find the maximum for each and every contiguous subarray of size k
    static void printMax(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> Qi = new LinkedList<>();
        // process first k (or first window) elements of array
        int i;
        for (i = 0; i < k; i++) {
            // for every element, the previous smaller elements are useless so remove them
            // from Qi
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]) {
                // remove from rear
                Qi.removeLast();
            }
            // add new element at the rear of queue
            Qi.addLast(i);
        }
        // process rest of the elements
        // i.e., from arr[k] to arr[n-1];

        for (; i < n; i++) {
            // the element at the front of the queue is the largest element of previous
            // window so print it

            System.out.print(arr[Qi.peek()] + " ");
            // Remove the element which are out of this window

            while (!Qi.isEmpty() && Qi.peek() <= i - k) {
                Qi.removeFirst();
            }
            // Remove all elements smaller than the currently being added element (remove
            // useless elements)

            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]) {
                Qi.removeLast();
            }
            // Add current element at the rear of Qi
            Qi.addLast(i);
        }
        // print the maximum element of last window

        System.out.print(arr[Qi.peek()]);
    }

    public static void main(String[] args) {

        int[] arr = { 2, 4, 7, 10, 12, 15, 25, 17 };
        int k = 3;
        printMax(arr, k);
    }
}
