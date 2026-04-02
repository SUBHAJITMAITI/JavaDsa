public class KnightsTour2 {
    public static int n = 8;
    public static int[][] arr = new int[n][n];
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

    public static boolean isSafe(int arr[][], int i, int j) {
        return i >= 0 && j >= 0 && i < arr.length && j < arr.length && arr[i][j] == -1;
    }

    public static boolean find(int arr[][], int i, int j, int v) {

        if (v == arr.length * arr.length ) {
            print(arr);
            return true;
        }
        // arr[i][j] = v;
        for (int t = 0; t < 8; t++) {
            int row = i + dx[t];
            int col = j + dy[t];
            if (isSafe(arr, row, col)) {
                arr[row][col] = v;
                if (find(arr, row, col, v + 1)) {
                    return true;
                }
                arr[row][col] = -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = -1;
            }
        }
        arr[0][0] = 0;
        find(arr, 0, 0, 1);
    }
}
