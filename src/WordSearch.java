// https://leetcode.com/problems/word-search/

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    int[][] lookup = new int[board.length][board[0].length];
                    if (exist(board, word, lookup, 0, i, j))
                        return true;
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, String word, int[][] lookup, int idx, int i, int j) {
        if (idx == word.length())
            return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || word.charAt(idx) != board[i][j] || lookup[i][j] == 1)
            return false;

        lookup[i][j] = 1;
        if (exist(board, word, lookup, idx + 1, i + 1, j) || exist(board, word, lookup, idx + 1, i - 1, j) ||
                exist(board, word, lookup, idx + 1, i, j + 1) || exist(board, word, lookup, idx + 1, i, j - 1))
            return true;

        lookup[i][j] = 0;
        return false;
    }
}