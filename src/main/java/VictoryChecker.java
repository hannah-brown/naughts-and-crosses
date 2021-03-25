import java.util.Arrays;

public class VictoryChecker {

    public boolean check(String[][] board) {
        return checkAllRows(board) || checkAllColumns(board) || checkDiagonals(board);
    }

    private boolean checkAllRows(String[][] board) {
        for (String[] row : board) {
            if(Arrays.equals(row, new String[]{"X", "X", "X"}) || Arrays.equals(row, new String[]{"O", "O", "O"})) {
                return true;
            }
        }
        return false;
    }

    private boolean checkAllColumns(String[][] board) {
        for(int i = 0; i < board[0].length; i++) {
            if(!board[0][i].isEmpty() && board[0][i].equals(board[1][i]) && board[0][i].equals(board [2][i])){
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(String[][] board) {
        return checkDiagonal(board, 0, 2) || checkDiagonal(board, 2, 0);
    }

    private boolean checkDiagonal(String[][] board, int i, int i3) {
        return !board[0][i].isEmpty() && board[0][i].equals(board[1][1]) && board[0][i].equals(board[2][i3]);
    }
}
