public class uppercaseCharactersToLowercaseUsingBts {
    public static void main(String[] args) {
        for (char i = 'A'; i <= 'Z'; i++) {
            
            System.out.print((char)(i|' '));
        }
    }
}
