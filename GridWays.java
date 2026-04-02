public class GridWays {
    public static int GridWaysFind(int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        } else if (i == n || j == m) {
            return 0;
        }
        int r = GridWaysFind(i + 1, j, n, m);
        int d = GridWaysFind(i, j + 1, n, m);
        return r + d;

    }

    public static void main(String[] args) {
        int n = 4, m = 5;
        System.out.println(GridWaysFind(0, 0, n, m));
    }
}
