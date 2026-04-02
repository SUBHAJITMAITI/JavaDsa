public class diagonalSum {
    public static int sum(int[][] arr) { //   time complexity O(n^2)
        int sum = 0;
        // for (int i = 0; i < arr.length; i++) {
        // for (int j = 0; j < arr[i].length; j++) {
        // if (i == j) {
        // sum += arr[i][j];
        // } else if (i + j == arr.length - 1) {
        // sum += arr[i][j];
        // }
        // }
        // }
        // return sum;
        // }

        //
        for (int i = 0; i < arr.length; i++) { //   time complexity O(n)
            // primary diagonal
            sum+=arr[i][i];
            //secondary diagonal
            if(i!=arr.length-i-1){
            sum+=arr[i][arr.length-i-1];
        }
    }
        return sum;
    }

    public static void main(String[] args) { // time complexity O(n^2)

        int[][] arr = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        System.out.println(sum(arr));
    }
}
