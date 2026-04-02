//-x=~x+1;
//-~x= x+1 ;
public class Add1usingBitwiseNOTOperator {
    public static void main(String[] args) {
        int x = -4;
        System.out.println(x + " + " + 1 + " is " + -~x);
        x = 5;
        System.out.println(x + " + " + 1 + " is " + -~x);
        x = 6;
        System.out.println(x + " + " + 1 + " is " + -~x);
    }
}
