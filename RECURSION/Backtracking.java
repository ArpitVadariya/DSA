import java.util.ArrayList;
import java.util.Arrays;

public class Backtracking {
    public static void main(String[] args) {

        // System.out.println(countSteps(3, 3));
        // path("", 3, 3);
        // System.out.println(pathList("", 3, 3));
        // System.out.println(pathDiagonalList("", 3, 3));

        // boolean board[][] = {
        // { true, true, true },
        // { true, true, true },
        // { true, true, true }
        // };

        // allpath("", board, 0, 0);
        // int path[][] = new int[board.length][board[0].length];
        // allpathSteps("", board, 0, 0, path, 1);

        // ---------------------------------------------------------

        // maze with pathRestriction
        // boolean board1[][] = {
        // { true, true, true },
        // { false, false, true },
        // { true, true, true }
        // };
        // pathRestriction(" ", board1, 0, 0);
        // System.out.println();

        // ---------------------------------------------------------
        System.out.println("\n\n\nEOF");
    }

    // only count path number that how many ways
    public static int countSteps(int row, int cols) {
        if (row == 1 || cols == 1) {
            return 1;
        }

        int left = countSteps(row - 1, cols);
        int right = countSteps(row, cols - 1);

        return left + right;
    }

    // this will give directions like RRDD DDRR RDRD etc
    public static void path(String p, int row, int cols) {
        if (row == 1 && cols == 1) {
            System.out.println(p);
            return;
        }

        if (row > 1) {
            path(p + 'D', row - 1, cols);
        }

        if (cols > 1) {
            path(p + 'R', row, cols - 1);
        }
    }

    // this will give list of paths like [ RRDD DDRR RDRD etc.]
    public static ArrayList<String> pathList(String p, int row, int cols) {
        if (row == 1 && cols == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if (row > 1) {
            list.addAll(pathList(p + 'D', row - 1, cols));
        }

        if (cols > 1) {
            list.addAll(pathList(p + 'R', row, cols - 1));
        }

        return list;
    }

    // this will give all direction paths Horizontal Vertical and Diagonal just like
    // VVHH, VHD, VHVH etc
    public static ArrayList<String> pathDiagonalList(String p, int row, int cols) {
        if (row == 1 && cols == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if (row > 1 && cols > 1) {
            list.addAll(pathDiagonalList(p + 'D', row - 1, cols - 1));
        }

        if (row > 1) {
            list.addAll(pathDiagonalList(p + 'V', row - 1, cols));
        }

        if (cols > 1) {
            list.addAll(pathDiagonalList(p + 'H', row, cols - 1));
        }

        return list;
    }

    public static void pathRestriction(String p, boolean maze[][], int row, int cols) {
        if (row == maze.length - 1 && cols == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        // maze[row][cols] == false --> !maze[row][cols]
        if (!maze[row][cols]) {
            return;
        }

        if (row < maze.length - 1) {
            pathRestriction(p + 'D', maze, row + 1, cols);
        }

        if (cols < maze[0].length - 1) {
            pathRestriction(p + 'R', maze, row, cols + 1);
        }
    }

    // this will all paths in matrix
    public static void allpath(String p, boolean maze[][], int row, int cols) {
        if (row == maze.length - 1 && cols == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        // maze[row][cols] == false --> !maze[row][cols]
        if (!maze[row][cols]) {
            return;
        }

        maze[row][cols] = false;

        if (row < maze.length - 1) {
            allpath(p + 'D', maze, row + 1, cols);
        }

        if (cols < maze[0].length - 1) {
            allpath(p + 'R', maze, row, cols + 1);
        }

        if (row > 0) {
            allpath(p + 'U', maze, row - 1, cols);
        }

        if (cols > 0) {
            allpath(p + 'L', maze, row, cols - 1);
        }

        maze[row][cols] = true;
    }

    // this will give all path direction with steps
    // for example :-
    // [1, 2, 0]
    // [0, 3, 0]
    // [0, 4, 5]
    // RDDR
    public static void allpathSteps(String p, boolean maze[][], int row, int cols, int path[][], int step) {
        if (row == maze.length - 1 && cols == maze[0].length - 1) {
            path[row][cols] = step;
            for (int arr[] : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        // maze[row][cols] == false --> !maze[row][cols]
        if (!maze[row][cols]) {
            return;
        }

        maze[row][cols] = false;
        path[row][cols] = step;
        if (row < maze.length - 1) {
            allpathSteps(p + 'D', maze, row + 1, cols, path, step + 1);
        }

        if (cols < maze[0].length - 1) {
            allpathSteps(p + 'R', maze, row, cols + 1, path, step + 1);
        }

        if (row > 0) {
            allpathSteps(p + 'U', maze, row - 1, cols, path, step + 1);
        }

        if (cols > 0) {
            allpathSteps(p + 'L', maze, row, cols - 1, path, step + 1);
        }

        maze[row][cols] = true;
        path[row][cols] = 0;
    }
}