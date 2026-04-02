import java.util.ArrayList;
import java.util.Collections;

public class Lonely_Numbers_in_ArrayList {
    public static void find(ArrayList<Integer> list) {
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            int curr = list.get(i);
            boolean isLonely = true;
            if (i > 0 && (list.get(i - 1) == curr || list.get(i - 1) == curr - 1)) {
                isLonely = false;
            }
            if (i < list.size() - 1 && (list.get(i + 1) == curr || list.get(i + 1) == curr + 1)) {
                isLonely = false;
            }
            if (isLonely) {
                System.out.print(list.get(i) + " ");
            }

        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // list.add(10);
        // list.add(6);
        // list.add(5);
        // list.add(8);
         list.add(1);
        list.add(3);
        list.add(5);
        list.add(3);

        find(list);
        // System.out.println(find(list));
    }
}
