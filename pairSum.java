import java.util.*;

public class pairSum { // O(n^2)
    public static boolean pairSum1(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean pairSum2(ArrayList<Integer> list, int target) { // O(n)
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {

            int total = list.get(left) + list.get(right);
            // case 1
            if (total == target) {
                return true;
            } else if (total < target) { // case 2
                left++;
            } else { // case 3
                right--;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target = 15;
        System.out.println(pairSum1(list, target));
        target = 7;
        System.out.println(pairSum2(list, target));
    }
}
