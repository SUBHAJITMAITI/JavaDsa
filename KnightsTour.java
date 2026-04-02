public class KnightsTour {
    public static int n = 8;
    public static int board[][] = new int[n][n];
    public static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
    public static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public static void print(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

                System.out.printf("%2d ", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int x, int y) {
        return (x >= 0 && y >= 0 && x < board.length && y < board.length && board[x][y] == -1);
    }

    public static boolean solveKnightsTour(int move, int row, int col) {
        if (move == n * n) {
            print(board);
            return true;
        }
        for (int i = 0; i < 8; i++) {
            int movx = row + dx[i];
            int movy = col + dy[i];
            if (isSafe(movx, movy)) {
                board[movx][movy] = move;
                if (solveKnightsTour(move + 1, movx, movy)) {
                    return true;
                }
                board[movx][movy] = -1;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = -1;
            }
        }
        board[0][0] = 0;
        solveKnightsTour(1, 0, 0);
    }
}
