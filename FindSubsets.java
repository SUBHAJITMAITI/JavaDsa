public class FindSubsets {
    public static void find(String s, int i, String t) {
        if (i == s.length()) {
            if (t.isEmpty()) {
                System.out.println("null");
                return;
            } else {
                System.out.println(t);
                return;
            }
        }

        find(s, i + 1, t + s.charAt(i)); //yes
        find(s, i + 1, t); //no
    }

    public static void main(String[] args) {
        String s = "abc";
        find(s, 0, "");
    }
}
