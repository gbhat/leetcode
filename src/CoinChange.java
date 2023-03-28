//https://leetcode.com/problems/coin-change

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int[] d : dp)
            Arrays.fill(d, Integer.MIN_VALUE);                          //Use MIN_VALUE as marker for DP. If we use MAX_VALUE, we will retry many times in recursion
        int ret = change(coins, amount, dp, coins.length - 1);
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }

    private int change(int[] coins, int amount, int[][] dp, int idx) {
        if (amount < 0 || idx < 0)
            return Integer.MAX_VALUE;                               //Use MAX_VALUE as marker for failure case

        if (dp[idx][amount] != Integer.MIN_VALUE)
            return dp[idx][amount];

        if (amount == 0)
            return 0;

        if (coins[idx] > amount)
            return change(coins, amount, dp, idx - 1);

        int without = change(coins, amount, dp, idx - 1);
        int with = change(coins, amount - coins[idx], dp, idx);
        if (without == Integer.MAX_VALUE && with == Integer.MAX_VALUE)
            return dp[idx][amount] =  Integer.MAX_VALUE;
        if (with == Integer.MAX_VALUE)
            return dp[idx][amount] =  without;
        if (without == Integer.MAX_VALUE)
            return dp[idx][amount] =  with + 1;
        return dp[idx][amount] =  Math.min(with + 1, without);
    }
}
