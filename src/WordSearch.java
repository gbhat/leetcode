// https://leetcode.com/problems/word-search/

// Modifies board to track if the character is visited
public class WordSearch {
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && check(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean check(char[][] board, String word, int i, int j, int idx) {
        if (idx == word.length() - 1 && board[i][j] == word.charAt(idx))
            return true;
        if (board[i][j] != word.charAt(idx))
            return false;

        board[i][j] = '-';
        for(int[] d : dir) {
            int next_i = i + d[0];
            int next_j = j + d[1];
            if (next_i >= 0 && next_i < board.length && next_j >= 0 && next_j < board[0].length) {
                if (check(board, word, next_i, next_j, idx + 1))
                    return true;
            }
        }
        board[i][j] = word.charAt(idx);
        return false;
    }
}