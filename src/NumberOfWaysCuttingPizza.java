//https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/

public class NumberOfWaysCuttingPizza {
    public int ways(String[] pizza, int k) {
        int[][][] dp = new int[pizza.length][pizza[0].length()][k + 1];
        return ways(pizza, 0, 0, k, dp);
    }

    private int ways(String[] pizza, int row, int col, int k, int[][][] dp) {
        int m = pizza.length;
        int n = pizza[0].length();
        if (k == 0 || row >= m || col >= n)
            return 0;

        if (dp[row][col][k] != 0)
            return dp[row][col][k];

        if (k == 1) {                                   // If we need only one cut, we search for any apple in remaining rows and columns
            for(int i = row; i < m; i++) {
                for(int j = col; j < n; j++) {
                    if (pizza[i].charAt(j) == 'A')
                        return 1;                       // If any apple found, we have one possible cut
                }
            }
            return 0;                                   // If no apples are found, no possible cuts
        }

        /*
            Try vertical cuts first. We should iterate for each column, and check if any apple in any rows for that column
            We also store a flag appleInPrevCol since we can try a cut which spans more than one column cuts if any previous columns had apple
            We also break from inner loop, after finding a row which contains an apple. Since a vertical cut is possible if any row in that column has apple.
            For example:
                        A . . .
                        A . . .             This will give only one column with apple. But we can cut at second/third column since previous column has apple
                        A . . .
         */
        long res1 = 0;
        boolean appleInPrevCol = false;
        for(int i = col; i < n; i++) {
            for(int j = row; j < m; j++) {
                if (appleInPrevCol || pizza[j].charAt(i) == 'A') {
                    appleInPrevCol = true;
                    res1 += ways(pizza, row, i + 1, k - 1, dp);
                    break;      // Once we find a cut across a column, do not attempt more rows in the same column. Try next column.
                }

            }
        }

        /* Try horizontal cuts similar to vertical cut above */
        long res2 = 0;
        boolean appleInPrevRow = false;
        for(int i = row; i < m; i++) {
            for(int j = col; j < n; j++) {
                if (appleInPrevRow || pizza[i].charAt(j) == 'A') {
                    appleInPrevRow = true;
                    res2 += ways(pizza, i + 1, col, k - 1, dp);
                    break;      // Once we find a cut across a row, do not attempt more columns in the same row. Try next row.
                }
            }
        }
        res1 = res1  % ((int) Math.pow(10, 9) + 7);
        res2 = res2  % ((int) Math.pow(10, 9) + 7);
        return dp[row][col][k] = (int)  (res1 + res2) % ((int) Math.pow(10, 9) + 7);
    }
}