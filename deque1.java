import java.util.Deque;
import java.util.*;
import java.util.LinkedList;

public class deque1 {

    public static void main(String[] args) {
        Deque<Integer> d = new LinkedList<>();
        d.addFirst(1);
        d.addFirst(2);
        System.out.println(d);
        d.addLast(3);
        d.addLast(4);
        d.addLast(5);
        System.out.println(d);
        System.out.println(d.removeFirst());
        System.out.println(d.removeLast());
        System.out.println(d);
        System.out.println("getFirst" + " : " + d.getFirst());
        System.out.println("getLast" + " : " + d.getLast());
    }
}
