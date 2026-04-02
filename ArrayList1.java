import java.util.ArrayList;

import java.util.Collections;

public class ArrayList1 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();
        list1.add(1);// O(1)
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        list1.add(1, 9);// O(n)

        System.out.println(list1);
        // get operation -O(1)
        System.out.println(list1.get(2));

        // delete -O(n)
        // list1.remove(2);
        // System.out.println(list1);

        // set -O(n)
        list1.set(2, 10);
        System.out.println(list1);
        // contains -O(n)
        System.out.println(list1.contains(0));
        System.out.println(list1.contains(10));

        // size
        // print the arraylist -O(n)
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " ");
        }

        System.out.println();

        // reverse print -O(n)
        for (int i = list1.size() - 1; i >= 0; i--) {
            System.out.print(list1.get(i) + " ");
        }

        System.out.println();

        // find maximum -O(n)
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list1.size(); i++) {
            if (max < list1.get(i)) {
                max = list1.get(i);
            }
        }
        System.out.println("max element : " + max);

        // swap two number
        System.out.println(list1);
        int idx1 = 1;
        int idx2 = 3;
        int temp = list1.get(idx1);
        list1.set(idx1, list1.get(idx2));
        list1.set(idx2, temp);
        System.out.println(list1);

        // sorting an arrayList

        Collections.sort(list1); // ascending
        System.out.println(list1);

        // descending
        Collections.sort(list1, Collections.reverseOrder());
        // Collections.reverseOrder() = comparator -fnx logic
        System.out.println(list1);

    }
}
