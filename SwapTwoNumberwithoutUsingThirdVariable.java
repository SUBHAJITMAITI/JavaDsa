public class SwapTwoNumberwithoutUsingThirdVariable {

    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        System.out.println(a + "," + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + "," + b);
    }
}
