//https://leetcode.com/problems/word-search-ii/

import java.util.*;

// This gives TLE.
public class WordSearch_II {
    int maxLen = Integer.MIN_VALUE;
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        for(String word : words) {
            set.add(word);
            maxLen = Math.max(maxLen, word.length());
        }

        Set<String> result = new HashSet<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                findWords(board, set, i, j, result, "");
            }
        }
        return new LinkedList<>(result);
    }

    private void findWords(char[][] board, Set<String> set, int x, int y, Set<String> result, String curStr) {
        if (set.contains(curStr))
            result.add(curStr);

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == '*' || curStr.length() > maxLen)
            return;

        curStr = curStr + board[x][y];

        char backup = board[x][y];
        board[x][y] = '*';
        findWords(board, set, x + 1, y, result, curStr);
        findWords(board, set, x - 1, y, result, curStr);
        findWords(board, set, x, y + 1, result, curStr);
        findWords(board, set, x, y - 1, result, curStr);
        board[x][y] = backup;
    }
}
