public class Towerofhenoi {
    public static void tower(int n, char a, char b, char c) {
        if (n == 0) {
            return;
        }
       
        tower(n-1, a, c, b);
        // System.out.println(n + " " + a + " " + c + " " + b);
        System.out.println(a + " to " + c);
        tower(n-1, b, a, c);
        
    }


    public static void main(String[] args) {
        tower(3, 'a', 'b', 'c');
    }
}
