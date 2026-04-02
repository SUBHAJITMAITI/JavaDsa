public class palindrome1 {

    public static boolean palindrome(String s) {
        int n = s.length();
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                //not palindrome
                return false;
            }
            
        }
        return true;
    }

    public static void main(String[] args) {

        String s = "noon";

        System.out.println(palindrome(s));
    }
}
