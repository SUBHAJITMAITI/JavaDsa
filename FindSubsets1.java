public class FindSubsets1 {
    public static void find(String s, int i, StringBuilder t) {
        if (i == s.length()) {
            if (t.isEmpty()) {
                System.out.println("null");
                return;
            } else {
                System.out.println(t);

                return;
            }
        }

        find(s, i + 1, t.append(s.charAt(i))); // yes
        t.deleteCharAt(t.length()-1);
        find(s, i + 1, t);
    }

    public static void main(String[] args) {
        String s = "abc";

        find(s, 0, new StringBuilder(""));
    }
}
