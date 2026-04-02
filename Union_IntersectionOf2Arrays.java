//Time Complexity = O(n+m)
//Space Complexity = O(n + m)
import java.util.HashSet;

public class Union_IntersectionOf2Arrays {
    public static void main(String[] args) {
        int arr1[] = { 7, 3, 9 };
        int arr2[] = { 6, 3, 9, 2, 9, 4 };
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            hs.add(arr2[i]);
        }
        System.out.print("union" + " = ");
        System.out.print(hs.size());
        System.out.print(" ( ");
        for (Integer e : hs) {
            System.out.print(e + " ");
        }
        System.out.println(")");
        hs.clear();

        for (Integer e : arr1) {
            hs.add(e);
        }
        int count = 0;
        System.out.print(" ( ");
        for (Integer e : arr2) {
            if (hs.contains(e)) {
                count++;
                System.out.print(e + " ");
                hs.remove(e);
            }
        }
        System.out.print(")");
        System.out.println("intersection = " + count);
    }
}
