public class shortestPath {
    public static double shortestPath(String s) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            //west
            if ('W' == s.charAt(i)) {
                x--;
            }
            //east
           else if ('E' == s.charAt(i)) {
                x++;
            }
            //north
             else if ('N' == s.charAt(i)) {
                y++;
            }
            //south
            else if ('S' == s.charAt(i)) {
                y--;
            }
        }

        return Math.sqrt((x * x) + (y * y));
    }

    public static void main(String[] args) {
        String s = "WNEENESENNN";
        System.out.println(shortestPath(s));
    }
}
