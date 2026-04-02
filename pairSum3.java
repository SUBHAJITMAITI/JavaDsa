import java.util.ArrayList;

public class pairSum3 {
    public static boolean pairSum(ArrayList<Integer> list, int target) {
        int bf = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                bf = i;
                break;
            }
        }
        // System.out.println(bf);
        int left = bf + 1;
        int right = bf;
        int n = list.size();

        while (left != right) {
            int total = list.get(left) + list.get(right);
            //case 1
            if (total == target) {
                return true;
            } else if (total < target) {     // case 2
                left = (left + 1) % n;
            } else {                         //case 3
                right = (n + right - 1) % n;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;
        System.out.println(pairSum(list, target));
    }
}
