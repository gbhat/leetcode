// https://leetcode.com/problems/maximal-square/

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int[][] lookup = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                lookup[i][j] = matrix[i][j] - '0';
                max = Math.max(max, lookup[i][j]);
            }
        }

        for(int i = 1; i < lookup.length; i++) {
            for(int j = 1; j < lookup[i].length; j++) {
                if (lookup[i][j] > 0) {
                    lookup[i][j] = min(lookup[i - 1][j - 1], lookup[i - 1][j], lookup[i][j - 1]) + 1;
                }
                max = Math.max(lookup[i][j], max);
            }
        }

        return max * max;
    }

    private int min(int a, int b, int c) {
        return a < b ? (a < c ? a : c) : (b < c ? b : c);
    }
}