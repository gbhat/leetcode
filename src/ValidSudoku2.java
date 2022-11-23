//https://leetcode.com/problems/valid-sudoku/

import java.util.*;

/*
    More compact solution. It is slower than previous, is it because hashset lookup?

    '4' in row 7 is encoded as "(4)7".
    '4' in column 7 is encoded as "7(4)".
    '4' in the top-right block is encoded as "0(4)2".
*/
public class ValidSudoku2 {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.')
                    continue;

                String str = "(" + board[i][j] + ")";
                if (!set.add(i + str) || !set.add(str + j) || !set.add(i / 3 + str + j / 3))
                    return false;
            }
        }
        return true;
    }
}