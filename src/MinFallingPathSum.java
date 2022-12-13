//https://leetcode.com/problems/minimum-falling-path-sum/

//This gives TLE
public class MinFallingPathSum {
    int min = Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] matrix) {
        for(int i = 0; i < matrix[0].length; i++) {
            min = Math.min(min, minSum(matrix, 0, i));
        }
        return min;
    }

    private int minSum(int[][] matrix, int row, int col) {
        if (row == matrix.length - 1)
            return matrix[row][col];

        int min = minSum(matrix, row + 1, col);
        if (col > 0)
            min = Math.min(min, minSum(matrix, row + 1, col - 1));
        if (col < matrix[0].length - 1)
            min = Math.min(min, minSum(matrix, row + 1, col + 1));
        return matrix[row][col] + min;
    }
}

