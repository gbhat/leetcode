//https://leetcode.com/problems/number-of-islands/

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    markZero(grid, i, j);   // Mark all the connected entries as zero
                }
            }
        }
        return count;
    }

    private void markZero(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length)
            return;
        if (grid[i][j] != '1')
            return;
        grid[i][j] = '0';
        markZero(grid, i + 1, j);
        markZero(grid, i, j + 1);
        markZero(grid, i - 1, j);
        markZero(grid, i, j - 1);
    }
}