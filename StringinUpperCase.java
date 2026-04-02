public class StringinUpperCase {
    public static String uppercase(String s) {
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            if (i < s.length() - 1 && s.charAt(i) == ' ') {
                sb.append(s.charAt(i));
                i++;
                char j = Character.toUpperCase(s.charAt(i ));
                sb.append(j);
            } else {
                sb.append(s.charAt(i));
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "hi i am subha";

        System.out.println(uppercase(s));

    }
}
