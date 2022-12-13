//https://leetcode.com/problems/minimum-falling-path-sum/

public class MinFallingPathSum2 {
    int min = Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] matrix) {
        int[][] lookup = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix[0].length; i++) {
            min = Math.min(min, minSum(matrix, 0, i, lookup));
        }
        return min;
    }

    private int minSum(int[][] matrix, int row, int col, int[][] lookup) {
        if (row == matrix.length - 1)
            return matrix[row][col];

        if (lookup[row][col] != 0)
            return lookup[row][col];

        int min = minSum(matrix, row + 1, col, lookup);
        if (col > 0)
            min = Math.min(min, minSum(matrix, row + 1, col - 1, lookup));
        if (col < matrix[0].length - 1)
            min = Math.min(min, minSum(matrix, row + 1, col + 1, lookup));
        lookup[row][col] = matrix[row][col] + min;
        return matrix[row][col] + min;
    }
}

