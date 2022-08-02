// import org.omg.Messaging.SyncScopeHelper;

public class NKnight {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        knight(board, 0, 0, 2);
        // System.out.println(knightC(board, 0, 0, 2));
    }
    // ---------------------------with counting---------------------------
    public static int knightC(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0;
        if (row == board.length - 1 && col == board.length) {
            return count;
        }

        if (col == board.length) {
            count += knightC(board, row + 1, 0, knights);
            return count;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            count += knightC(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }

        count += knightC(board, row, col + 1, knights);

        return count;
    }

    // ---------------------------without counting---------------------------
    static int cnt = 0;
    public static void knight(boolean[][] board, int row, int col, int knights) {

        if (knights == 0) {
            display(board);
            cnt++;
            System.out.println();
            System.out.println("cnt = " + cnt);
            System.out.println();
            return;
        }

        if (row == board.length - 1 && col == board.length) {
            return;
        }

        if (col == board.length) {
            knight(board, row + 1, 0, knights);
            return;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            knight(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }

        knight(board, row, col + 1, knights);

        return;
    }

    public static boolean isSafe(boolean[][] board, int row, int col) {
        if(isValid(board, row - 1, col - 2)){
            if(board[row - 1][col - 2]){
                return false;
            }
        }

        if(isValid(board, row - 1, col + 2)){
            if(board[row - 1][col + 2]){
                return false;
            }
        }

        if(isValid(board, row - 2, col - 1)){
            if(board[row - 2][col - 1]){
                return false;
            }
        }

        if(isValid(board, row - 2, col + 1)){
            if(board[row - 2][col + 1]){
                return false;
            }
        }

        return true;
    }

    public static boolean isValid(boolean[][] board, int row, int col){
        if(row >= 0 && row < board.length && col >= 0 && col < board.length){
            return true;
        }

        return false;
    }

    public static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

}