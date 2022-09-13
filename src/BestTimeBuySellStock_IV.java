//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

import java.util.*;

public class BestTimeBuySellStock_IV {
    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length/2) {
            int max = 0;
            for(int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1])
                    max += prices[i] - prices[i - 1];
            }
            return max;
        }

        int[][] dp = new int[k + 1][prices.length];
        for(int i = 1; i <= k; i++) {
            int curProfit = Integer.MIN_VALUE;
            for(int j = 1; j < prices.length; j++) {
                curProfit = Math.max(curProfit, dp[i - 1][j - 1] - prices[j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], curProfit + prices[j]);
            }
        }
/*
        for(int i = 0; i <= k; i++)
            System.out.println(Arrays.toString(dp[i]));
*/
        return dp[k][prices.length - 1];
    }
}
