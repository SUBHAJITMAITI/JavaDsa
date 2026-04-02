//Time Complexity: O(N²) due to nested loops (for prev and next).

// Space Complexity: O(N) for arrays.

import java.util.*;
class AreaUnderTheHistogram {
    public static void main(String[] args) {
        int[] arr={4,2,1,5,6,3,2,4,2};
        int []prev=new int[arr.length];
        int []next=new int[arr.length];
        int []width=new int[arr.length];
         int []area=new int[arr.length];

        for(int i=0;i<arr.length;i++){
            int temp =arr[i];
            
            int j=0;
            for( j=i-1;j>=0;j--){
                if(temp>arr[j]){
                  break;
                }
            }
            prev[i]=j;
        }
        System.out.println(Arrays.toString(prev));
        
        for(int i=0;i<arr.length;i++){
            int temp =arr[i];
           
            int j=0;
            for( j=i+1;j<arr.length;j++){
                if(temp>arr[j]){
                  break;
                }
            }
            next[i]=j;
        }
         System.out.println(Arrays.toString(next));

        for(int i=0;i<arr.length;i++){
           width[i]=next[i]-prev[i]-1;
        }
         System.out.println(Arrays.toString(width));
        
         for(int i=0;i<arr.length;i++){
             area[i]=width[i]*arr[i];
         }
         System.out.println(Arrays.toString(area));
        
         int temp=area[0];
         int j=0;
        for(int i=1;i<area.length;i++){
            
            if(temp<area[i]){
                temp=area[i];
                j=i;
            }
        }
        System.out.println("Max Area: "+ temp+" (at height " + arr[j] + ")");
    }
}