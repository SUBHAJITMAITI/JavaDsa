import java.util.ArrayList;

public class Beautiful_ArrayList {


    // Approach 1(Iterative)

    public static ArrayList<Integer> BeautifulArrayList(ArrayList<Integer> list, int n) {
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        for (int i = 1; i < n; i++) {
            ArrayList<Integer> list3 = new ArrayList<>();
            for (Integer e : list2) {
                if (e * 2 <= n) {
                    list3.add(e * 2);        // 🌱 Even Branch
                }
            }
            for (Integer e : list2) {
                if ((e * 2) - 1 <= n) {
                    list3.add((e * 2) - 1);         // 🌱 Odd Branch
                }
            }
            list2 = list3;
        }
        return list2;
    }

    // Approach 2(Iterative)

   public static ArrayList<Integer> beautifulArray(int n) {
    ArrayList<Integer> res = new ArrayList<>();
    res.add(1);

    while (res.size() < n) {
        ArrayList<Integer> next = new ArrayList<>();
        for (int e : res) {
            if (e * 2 <= n) next.add(e * 2);     // even
        }
        for (int e : res) {
            if (e * 2 - 1 <= n) next.add(e * 2 - 1); // odd
        }
        res = next;
    }

    return res;
}


    // Approach 2(Divide & Conquer)

    public static void divideConque(int start, int increase, ArrayList<Integer> list, int n) {
        if (start + increase > n) {
            list.add(start);
            return;
        }
        divideConque(start, 2 * increase, list, n);
        divideConque(start + increase, 2 * increase, list, n);
    }

    public static ArrayList<Integer> BeautifulArrayList1(int n) {
        ArrayList<Integer> list2 = new ArrayList<>();
        divideConque(1, 1, list2, 4);
        return list2;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = 5;
        // ArrayList<Integer> list4 = BeautifulArrayList(list, n);

         for (Integer e : BeautifulArrayList(list,n)) {
            System.out.print(e + " ");
        }
        System.out.println();
        for (Integer e : beautifulArray(n)) {
            System.out.print(e + " ");
        }

        // for (Integer e : BeautifulArrayList1(n)) {
        // System.out.print(e + " ");
        // }

    }
}