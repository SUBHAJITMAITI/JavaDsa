public class Permutation {
    public static void findPermutation(String str, String newString) {
        // base case
        if (str.length() == 0) {
            System.out.println(newString);
            return;
        }
        // recursion
        // time complexity -  O(n*n!)
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            // "abcde" =>"ab"+"de"="abde"
            String newstr = str.substring(0, i) + str.substring(i + 1);
            findPermutation(newstr, newString + s);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        findPermutation(str, " ");
    }
}
