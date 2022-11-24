//https://leetcode.com/problems/perfect-squares/

import java.util.*;

// Bottom up DP. Works with all inputs.
public class PerfectSquares3 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.setAll(dp, i -> isSquare(i) ? 1 : i);
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i / 2; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
            }
        }
        return dp[n];
    }

    private boolean isSquare(int n) {
        double sqrt = Math.sqrt(n);
        return sqrt - (int) sqrt == 0;
    }
}
