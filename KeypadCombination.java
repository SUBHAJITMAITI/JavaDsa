public class KeypadCombination {
    public static String[] arr = { " ", ".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static void findCombination(String s, String newString, int i) {

        if (i == s.length()) {
            System.out.print( '"'+newString+'"' + " ");
            return;
        }
        char c = s.charAt(i);
        // System.out.println(c);
        String h = arr[c - '0'];
        for (int j = 0; j < h.length(); j++) {
            findCombination(s, newString + h.charAt(j), i + 1);
        }
    }

    public static void main(String[] args) {
        String s = "23";
        findCombination(s, "", 0);
    }
}
