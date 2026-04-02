public class sudoku1 {
    // public static int n = 8;
    // public static int board[][] = new int[n][n];

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int[][] board, int row, int col, int val) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == val) {
                return false;
            }
        }
        int j = (row / 3) * 3;
        int t = (col / 3) * 3;
        for (int i = j; i < j + 3; i++) {
            for (int k = t; k < t + 3; k++) {
                if (board[i][k] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuFind(int[][] board, int row, int col) {
        if (row == 9) {
            print(board);
            return true;
        }
        int newRow = row, newcol = col + 1;
        if (newcol == 9) {
            newRow = row + 1;
            newcol = 0;
        }
        if (board[row][col] != 0) {
            return sudokuFind(board, newRow, newcol);

        }

        for (int j = 1; j <= 9; j++) {
            if (isSafe(board, row, col, j)) {
                board[row][col] = j;
                if (sudokuFind(board, newRow, newcol)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] board = {
                { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 }
        };
        sudokuFind(board, 0, 0);
    }
}
