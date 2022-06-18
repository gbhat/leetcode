//https://leetcode.com/problems/n-queens-ii/

public class N_Queens_II {
    int total = 0;
    public int totalNQueens(int n) {
        total = 0;
        int[][] board = new int[n][n];
        solveNQ(n, board, 0);
        return total;
    }

    private void solveNQ(int n, int[][] board, int col) {
        if (col == n) {
            // for(int i =0 ; i < n; i++) {
            //     for(int j = 0; j < n; j++) {
            //         System.out.print(board[i][j] + "  ");
            //     }
            //     System.out.println();
            // }
            // System.out.println("\n\n");
            total++;
            return;
        }

        for(int row = 0; row < n; row++) {
            if (isSafe(board, n, row, col)) {
                board[row][col] = 1;
                solveNQ(n, board, col + 1);
            }
            board[row][col] = 0;
        }
    }

    private boolean isSafe(int[][] board, int n, int row, int col) {
        for(int i = col; i >= 0; i--)
            if (board[row][i] == 1)
                return false;

        for(int i = row, j = col; i >= 0 && j >= 0; i--,j--)
            if (board[i][j] == 1)
                return false;
        for(int i = row, j = col; i < n && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
    }
}

