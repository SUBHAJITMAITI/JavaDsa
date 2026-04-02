public class Nqueens {
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
        for (int l = row - 1; l >= 0; l--) {
            if (arr[l][i] == 'Q') {
                return false;
            }
        }
        // diag left up
        for (int l = row - 1, k = i - 1; l >= 0 && k >= 0; l--, k--) {
            if (arr[l][k] == 'Q') {
                return false;
            }
        }
        // diag right up
        for (int l = row - 1, k = i + 1; l >= 0 && k < arr.length; l--, k++) {
            if (arr[l][k] == 'Q') {
                return false;
            }
        }

        return true;
    }

    static int count = 0;

    // public static void N_queens(char arr[][], int row) {
    // if (row == arr.length) {
    // System.out.println("new board");
    // print(arr);
    // count++;
    // return;
    // }
    // for (int i = 0; i < arr.length; i++) {

    // if (isSafty(arr, i, row)) {
    // arr[row][i] = 'Q';
    // N_queens(arr, row + 1);
    // arr[row][i] = 'X';
    // }
    // }
    // }

    // for 1 solution
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
                if (N_queens(arr, row + 1)) {
                    return true;
                }
                arr[row][i] = 'X';
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int n = 5;
        char[][] arr = new char[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 'X';
            }

        }
        N_queens(arr, 0);
        System.out.println("Total solutions : " + count);
    }
}
