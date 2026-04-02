//Implementation of Queue Data Structure Using Stack
//Time complexity of enQueue : O(1)
//Time complexity of deQueue : O(n)
//Space complexity : O(n)



import java.util.*;

public class queueUsingStack {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    //insertion of data in the queue
    //time complexity - O(1)
    public static void enqueue(int data) {
        stack1.push(data);
    }

    //deletion of the data from the queue-FIFO
    public static int dequeue() {
        int ele = -1;
        if (stack1.empty() && stack2.empty()) {
            System.out.println("stack is empty");
            System.exit(0);
        } 
        //push all the elements from the stack1 to stack2
        //time complexity : O(n)
        else if (stack2.empty()) {

            while (!stack1.empty()) {
                ele = stack1.pop();
                stack2.push(ele);
            }
        }
        //Pop the top element from  stack2
        //FIFO-first in first out
        ele = stack2.pop();
        return ele;
    }

    public static void main(String[] args) {
        queueUsingStack q = new queueUsingStack();

        //function calling for insertion in the queue
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        //function calling for deletion of an element from the queue
        System.out.println("Deleted element is : "+q.dequeue());
        System.out.println("Deleted element is : "+q.dequeue());
       
    }
}
