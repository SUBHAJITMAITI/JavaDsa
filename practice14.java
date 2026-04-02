import java.util.Scanner;

public class practice14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            boolean f = false;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    System.out.println(i + " : the number is not prime");
                    f = true;
                    break;
                }
            }
            if (!f) {

                System.out.println(i + " : the number is  prime");
            }
        }

    }
}
