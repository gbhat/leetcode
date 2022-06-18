//https://leetcode.com/problems/unique-paths-ii/

public class UniquePaths_II {
    int totalPaths = 0;
    public int uniquePathsWithObstacles(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (grid[0][0] == 1)
            return 0;

        grid[0][0] = 1;

        for(int i = 1; i < rows; i++)
            grid[i][0] = (grid[i][0] == 0 && grid[i - 1][0] == 1) ? 1 : 0;

        for(int i = 1; i < cols; i++)
            grid[0][i] = (grid[0][i] == 0 && grid[0][i - 1] == 1) ? 1 : 0;

        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if (grid[i][j] == 0)
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                else
                    grid[i][j] = 0;
            }
        }

        return grid[rows - 1][cols - 1];
    }
}