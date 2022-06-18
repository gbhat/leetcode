//https://leetcode.com/problems/n-queens/

import java.util.*;
import java.util.stream.Collectors;

public class N_Queens {
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];

        List<List<String>> result = new LinkedList<>();
        solveNQ(board, result, 0);
        return result;
    }

    private void solveNQ(int[][] board , List<List<String>> result, int col) {
        if (col == board.length) {
            List<String> res = new LinkedList<>();
            for(int[] b : board) {
                String str = Arrays.stream(b).mapToObj(t -> t == 0 ? "." : "Q").collect(Collectors.joining(""));
                res.add(str);
            }
            result.add(res);
            return;
        }

        for(int row = 0; row < board.length; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                solveNQ(board, result, col + 1);
            }
            board[row][col] = 0;
        }
    }

    private boolean isSafe(int[][] board, int row, int col) {
        for(int i = col; i >= 0; i--)
            if (board[row][i] == 1)
                return false;

        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for(int i = row, j = col; i < board.length && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
    }
}
