public class Rat_in_a_Maze1 {
    public static void solve(int[][] maze, int i, int j, String s) {
        if (i<0|| j<0||i >= maze.length || j >= maze.length || maze[i][j] == -1 || maze[i][j] == 0) {
            return;
        }
        if (i == maze.length - 1 && j == maze.length - 1) {
            System.out.println(s);
            return;
        }
        maze[i][j] = -1;
        solve(maze, i, j + 1, s + "r");
        solve(maze, i + 1, j, s + "d");
        solve(maze, i - 1, j, s + "u");
        solve(maze, i, j - 1, s + "l");
        maze[i][j] = 1;
    }

    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
        maze[0][0] = 1;
        solve(maze, 0, 0, "");
    }
}
