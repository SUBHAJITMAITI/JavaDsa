public class stringbuilder1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("");
        for (char i = 'a'; i <= 'z'; i++) {
            sb.append(i);
        }
        // O(26)
        // O(26* n^2)
        System.out.println(sb);
        System.out.println(sb.length());
    }
}

