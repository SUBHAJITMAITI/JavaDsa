public class Nqueens1 {
    public static void print(char arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafty(char[][] arr, int i, int row) {
        // vertical up
        for (int j = row - 1; j >= 0; j--) {
            if (arr[j][i] == 'Q') {
                return false;
            }
        }
        // diag left up
        for (int j = row - 1, k = i - 1; j >= 0 && k >= 0; j--, k--) {
            if (arr[j][k] == 'Q') {
                return false;
            }
        }
        // diag right up
        for (int j = row - 1, k = i + 1; j >= 0 && k <arr.length; j--, k++) {
            if (arr[j][k] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static int count = 0;

    public static boolean N_queens(char arr[][], int row) {
        if (row == arr.length) {
            System.out.println("new board");
            print(arr);
            
            count++;
            return true;
        }
        for (int i = 0; i < arr.length; i++) {
            if (isSafty(arr, i, row)) {
                arr[row][i] = 'Q';
               if( N_queens(arr, row + 1)){
                return true;
               }
                arr[row][i] = 'X';
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 1;
        char arr[][] = new char[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 'X';
            }
        }
        N_queens(arr, 0);
        System.out.println( "total solution:"+ count);
    }
}