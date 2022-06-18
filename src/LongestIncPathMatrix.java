//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

public class LongestIncPathMatrix {
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int max = 1;
    public int longestIncreasingPath(int[][] matrix) {
        int[][] lookup = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                findLIP(matrix, lookup, i, j);
            }
        }
        return max;
    }

    private int findLIP(int[][] matrix, int[][] lookup, int i, int j) {
        if (lookup[i][j] != 0)
            return lookup[i][j];

        int maxPath = 1;
        for(int[] d : dir) {
            int nexti = i + d[0];
            int nextj = j + d[1];
            if (nexti >= 0 && nexti < matrix.length && nextj >= 0 && nextj < matrix[0].length && matrix[nexti][nextj] > matrix[i][j]) {
                maxPath = Math.max(maxPath, 1 + findLIP(matrix, lookup, nexti, nextj));
                max = Math.max(max, maxPath);
            }

        }
        lookup[i][j] = maxPath;
        return maxPath;
    }
}