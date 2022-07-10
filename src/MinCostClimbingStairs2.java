//https://leetcode.com/problems/min-cost-climbing-stairs/

// DP solution with O(n) memory. Check MinCostClimbingStairs3.java
public class MinCostClimbingStairs2 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        return minCost(cost, dp, cost.length);
    }

    private int minCost(int[] cost, int[] dp, int idx) {
        if (idx < 0)
            return 0;

        if (dp[idx] > 0)
            return dp[idx];

        int curCost = idx < cost.length ? cost[idx] : 0;
        int totalCost =  Math.min(curCost + minCost(cost, dp, idx - 1), curCost + minCost(cost, dp, idx - 2));
        dp[idx] = totalCost;
        return totalCost;
    }
}
