public class problem {

    public static int[] prob(int arr[]) {
        int[] temp = new int[arr.length];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                temp[k] = arr[i];
                k++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                temp[k] = arr[i];
                k++;
            }
        }
        return temp;
    }

    public static int[] twoPointer(int arr[]) {
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
            if (arr[left] < 0 && arr[right] < 0) {
                left++;

            } else if (arr[left] >= 0 && arr[right] < 0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            } 
            else if(arr[left] >= 0 && arr[right] >= 0) {

                right--;
            }
            else{
                left++;
                right--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = { 2, -9, 10, 12, 5, -2, 10, -4 };
        int arr1[] = prob(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr1[i] + " ");

        }
        System.out.println();
        int arr2[] =  twoPointer(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr2[i] + " ");

        }

    }
}