public class practice13 {


    public static int sum(int[]arr){
        int total=0;
        for(int e: arr){
            if(e%2==0){
            total+=e;
        }
        }
        return total;
    } 
    public static void main(String[] args) {
        // int n=sum(1,2,3,4,5,6);
        System.out.println(sum(new int[]{1,2,3,4,5,6}));
    }
}
