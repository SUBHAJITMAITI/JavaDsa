public class profit {
     public static int   find_profit(int arr[]){
        int profit=0;
        int min=arr[0];
        for(int i=1;i<arr.length;i++){
            if(min>arr[i]){
                min=arr[i];
            }
            else{
                profit=Math.max(profit,arr[i]-min);
            }
        }
        return profit;
    }
    public static void main(String[] args) {
          int arr[]={1,2,3,4,5,6,7};
         System.out.println( find_profit(arr));
    }
}
