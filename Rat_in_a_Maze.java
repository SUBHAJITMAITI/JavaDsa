public class Rat_in_a_Maze {
    // public static int count = 0;

    public static void solveMaze(int maze[][], int row, int col, String s) {

        if (row < 0 || col < 0 || row >= maze.length || col >= maze.length || maze[row][col] == 0
                || maze[row][col] == -1) {
            return;
        }
        if (row == maze.length - 1 && col == maze.length-1) {
            System.out.println(s);
            return;
        }
        maze[row][col] = -1;
        solveMaze(maze, row - 1, col, s + "U");
        solveMaze(maze, row, col + 1, s + "R");
        solveMaze(maze, row, col - 1, s + "L");
        solveMaze(maze, row + 1, col, s + "D");
        maze[row][col] = 1;
    }

    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
        solveMaze(maze, 0, 0, " ");
        // System.out.println(count);
    }
}
