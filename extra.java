public class extra {
    public static void binarytodecimal(int ch) {
        long f = 0;
        int num = ch;
        int pow = 0;
        while (num > 0) {
            int r = ch%2;
            f = f + (int)Math.pow(10, pow)*r;
            pow++;
            num = num / 2;

        }
        System.out.println(f);

    }

    public static void main(String[] args) {
        int ch = 15;
        binarytodecimal(ch);
    }
}
