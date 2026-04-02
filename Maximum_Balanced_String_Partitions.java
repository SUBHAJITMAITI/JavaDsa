//Time Complexity → O(n)
//Space Complexity → O(1)
public class Maximum_Balanced_String_Partitions {
    public static void main(String[] args) {
        String s = "LRRRRLLRLLRL";
        int balance = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                balance++;
            } else {
                balance--;
            }
            if (balance == 0) {
                count++;
            }
        }
        System.out.println("Total balance count : " + count);
    }
}
