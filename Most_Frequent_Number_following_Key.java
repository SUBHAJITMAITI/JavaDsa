import java.util.*;

public class Most_Frequent_Number_following_Key {
    public static int mostFrequent(ArrayList<Integer> list, int key) {

        int[] arr = new int[1000];
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == key) {
                arr[list.get(i + 1) - 1]++;

            }
        }

        int max = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];

                result = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(100);
        // list.add(200);
        // list.add(1);
        // list.add(100);
         list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);

        int key = 2;
        System.out.println(mostFrequent(list, key));
    }
}
