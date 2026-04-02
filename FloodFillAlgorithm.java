//Time Complexity=O(N×M)
//Space Complexity=O(N×M)
public class FloodFillAlgorithm {
    public static void helper(int[][] image, int sr, int sc, int color, boolean[][] visit, int orgCo) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || visit[sr][sc]
                || image[sr][sc] != orgCo) {
            return;
        }
        visit[sr][sc] = true;
        image[sr][sc] = color;

        // left
        helper(image, sr, sc - 1, color, visit, orgCo);
        // right
        helper(image, sr, sc + 1, color, visit, orgCo);
        // up
        helper(image, sr - 1, sc, color, visit, orgCo);
        // down
        helper(image, sr + 1, sc, color, visit, orgCo);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean visit[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, visit, image[sr][sc]);
        return image;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        FloodFillAlgorithm f = new FloodFillAlgorithm();
        f.floodFill(arr, 1, 1, 2);

        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
