public class LargestString {
    public static void main(String[] args) {
        String[] arr = { "apple", "mango", "banana" };
        String large = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (large.compareTo(arr[i]) < 0) {
                large = arr[i];
            }
        }
System.out.println(large);
    }
}
