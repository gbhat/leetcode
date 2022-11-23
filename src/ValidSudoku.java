//https://leetcode.com/problems/valid-sudoku/

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.')
                    continue;
                if (check(board, board[i][j], i, j))
                    return false;
            }
        }
        return true;
    }

    private boolean check(char[][] board, char target, int row, int col) {
        for(int i = 0; i < board[0].length; i++) {
            if (i != row && board[i][col] == target)
                return true;
        }
        for(int i = 0; i < board.length; i++) {
            if (i != col && board[row][i] == target)
                return true;
        }

        int boxX = 3 * (row / 3);
        int boxY = 3 * (col / 3);
        for (int i = boxX; i < boxX + 3; i++) {
            for (int j = boxY; j < boxY + 3; j++) {
                if (i != row && j != col && board[i][j] == target)
                    return true;
            }
        }
        return false;
    }
}
