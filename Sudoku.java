public class Sudoku {
    public static void print(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int[][] sudokusolver, int row, int col, int digit) {
        // row
        for (int i = 0; i < sudokusolver.length; i++) {
            if (sudokusolver[row][i] == digit) {
                return false;
            }
        }
        // colum
        for (int i = 0; i < sudokusolver.length; i++) {
            if (sudokusolver[i][col] == digit) {
                return false;
            }
        }
        // grid
        int g = (row / 3) * 3;
        int h = (col / 3) * 3;
        for (int i = g; i < g + 3; i++) {
            for (int j = h; j < h + 3; j++) {
                if (sudokusolver[i][j] == digit) {
                    return false;
                }

            }

        }
        return true;
    }

    public static boolean sudokusolver(int[][] sudokusolver, int row, int col) {

        // base case
        if (row == 9) {

            return true;
        }
        int newrow = row, newcolum = col + 1;
        if (newcolum == 9) {
            newrow = row + 1;
            newcolum = 0;
        }
        if (sudokusolver[row][col] != 0) {
            return sudokusolver(sudokusolver, newrow, newcolum);

        }

        for (int j = 1; j <= 9; j++) {
            if (isSafe(sudokusolver, row, col, j)) {
                sudokusolver[row][col] = j;
                if (sudokusolver(sudokusolver, newrow, newcolum)) {
                    return true;
                }

                sudokusolver[row][col] = 0;

            }
        }

        return false;

    }

    public static void main(String[] args) {
        int[][] sudoku = {
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

        if (sudokusolver(sudoku, 0, 0)) {
            System.out.println("solution exists : ");
            print(sudoku);
        } else {
            System.out.println("solution does not exists");
        }

    }
}
