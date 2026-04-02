//time complexity- O(n);
//space complexity- O(1);
public class findOnlyNonRepeatingElement {
    public static void main(String[] args) {
        int arr[] = { 5, 4, 1, 4, 3, 5, 1 };
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }
        System.out.println(res);
    }
}
