public class keypadCombinations1 {
    public static String[] arr = { " ", ".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static void findcombination(String s, int n, int i, String t) {
        if (t.length() == n) {
            System.out.print(t + " ");
            return;
        }
        char c = s.charAt(i);
        String d = arr[c - '0'];
        for (int j = 0; j < d.length(); j++) {
            findcombination(s, n, i + 1, t + d.charAt(j));
        }

    }

    public static void main(String[] args) {
        String s = "23";
     
        findcombination(s, s.length(), 0, "");
    }
}
