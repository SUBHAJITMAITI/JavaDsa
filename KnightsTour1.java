public class KnightsTour1 {

    public static boolean isValid(int[][] board, int i, int j, int move) {
        if ((i < 0 || j < 0 || i >= board.length || j >= board.length || board[i][j]!=move) ) {
            return false;
        }

        if (move == board.length * board.length - 1) {
            return true;
        }

        boolean s = isValid(board, i - 2, j + 1, move + 1);
        boolean u = isValid(board, i - 1, j + 2, move + 1);
        boolean b = isValid(board, i + 1, j + 2, move + 1);
        boolean h = isValid(board, i + 2, j + 1, move + 1);
        boolean a = isValid(board, i + 2, j - 1, move + 1);
        boolean m = isValid(board, i + 1, j - 2, move + 1);
        boolean t = isValid(board, i - 1, j - 2, move + 1);
        boolean l = isValid(board, i - 2, j - 1, move + 1);

        return s || u || b || h || a || m || t || l;
    }

    public static void main(String[] args) {
        int[][] board = {
        { 0, 59, 38, 33, 30, 17, 8, 63 },
        { 37, 34, 31, 60, 9, 62, 29, 16 },
        { 58, 1, 36, 39, 32, 27, 18, 7 },
        { 35, 48, 41, 26, 61, 10, 15, 28 },
        { 42, 57, 2, 49, 40, 23, 6, 19 },
        { 47, 50, 45, 54, 25, 20, 11, 14 },
        { 56, 43, 52, 3, 22, 13, 24, 5 },
        { 51, 46, 55, 44, 53, 4, 21, 12 }
        };
        // int[][] board = { {0,3,6}, {5,8,1}, {2,7,4} };
        System.out.println(isValid(board, 0, 0, 0));
    }
}
