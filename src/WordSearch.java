// https://leetcode.com/problems/word-search/
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    int[][] lookup = new int[board.length][board[0].length];
                    lookup[i][j] = 1;
                    if (check(board, word, 0, i, j, lookup))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, String word, int idx, int board_x, int board_y, int[][] lookup) {
        if (idx == word.length()-1 && board[board_x][board_y] == word.charAt(idx))
            return true;

        if (board_x + 1 < board.length && lookup[board_x + 1][board_y] == 0 && board[board_x + 1][board_y] == word.charAt(idx + 1)) {
            lookup[board_x + 1][board_y] = idx + 1;
            if (check(board, word, idx + 1, board_x + 1, board_y, lookup))
                return true;
            lookup[board_x + 1][board_y] = 0;
        }

        if (board_x - 1 >= 0 && lookup[board_x - 1][board_y] == 0 && board[board_x - 1][board_y] == word.charAt(idx + 1)) {
            lookup[board_x - 1][board_y] = idx + 1;
            if (check(board, word, idx + 1, board_x - 1, board_y, lookup))
                return true;
            lookup[board_x - 1][board_y] = 0;
        }

        if (board_y + 1 < board[board_x].length && lookup[board_x][board_y + 1] == 0 && board[board_x][board_y + 1] == word.charAt(idx + 1)) {
            lookup[board_x][board_y + 1] = idx + 1;
            if (check(board, word, idx + 1, board_x, board_y + 1, lookup))
                return true;
            lookup[board_x][board_y + 1] = 0;
        }

        if (board_y - 1 >= 0 && lookup[board_x][board_y - 1] == 0 && board[board_x][board_y - 1] == word.charAt(idx + 1)) {
            lookup[board_x][board_y - 1] = idx + 1;
            if (check(board, word, idx + 1, board_x, board_y - 1, lookup))
                return true;
            lookup[board_x][board_y - 1] = 0;
        }

        return false;

    }
}