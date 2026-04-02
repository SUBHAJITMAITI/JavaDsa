//time complexity- O(n);
//space complexity- O(1);
public class findTwoNonRepeatingElement {
    public static void main(String[] args) {
        int arr[] = { 5, 4, 1, 4, 3, 5, 1, 2 };
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }
        int temp = res;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & 1) != 1) {
                temp ^= arr[i];
            }

        }
        System.out.println(temp + " , " + (temp ^ res));
    }
}
