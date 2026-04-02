import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //size of an element from the user
        System.out.print("Enter the number of element present in an array : ");
        int n = sc.nextInt();
        //array elements entered from the user
        System.out.print("Enter the array elements : ");
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //target  element from the user
        System.out.print("Enter target element : ");
        int num = sc.nextInt();
        //implementation of linear Search
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == num) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            System.out.println("searched element is not found in an array " );
        } else {
            System.out.println("searched element is  found in an array at the location  : "+ idx);
        }

    }

}