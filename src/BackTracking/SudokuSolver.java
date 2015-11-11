package BackTracking;

/**
 * Created by zxm on 11/11/15.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if (board == null) return;
        solveSudokuHelper(board, 0, 0);

    }

    public boolean solveSudokuHelper(char[][] board, int row, int col) {
        if (col == board[0].length) {
            return solveSudokuHelper(board, row + 1, 0);
        }
        if (row == board.length) return true;
        if (board[row][col] != '.') {
            return solveSudokuHelper(board, row, col + 1);
        }
        for (char ch = '1'; ch <= '9'; ch++) {
            if (isValidSudoku(board, row, col, ch)) {
                board[row][col] = ch;
                if (solveSudokuHelper(board, row, col + 1)) return true;
                board[row][col] = '.';
            }

        }

        return false;
    }

    public boolean isValidSudoku(char[][] board, int row, int col, char ch) {
        //check the row
        for (int j = 0; j < board[0].length; j++) {
            if (board[row][j] == ch) return false;
        }
        //check the col
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == ch) return false;
        }
        //check local square
        int len = 3;
        int startRow = (row / len) * len;
        int startCol = (col / len) * len;
        for (int i = startRow; i < startRow + len; i++) {
            for (int j = startCol; j < startCol + len; j++) {
                if (board[i][j] == ch) return false;
            }
        }

        return true;

    }
}
