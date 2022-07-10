//https://leetcode.com/problems/min-cost-climbing-stairs/

// Recursive solution. Check MinCostClimbingStairs2.java and MinCostClimbingStairs3.java
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        return minCost(cost, -1);
    }

    private int minCost(int[] cost, int cur) {
        if (cur >= cost.length)
            return 0;

        int curCost = cur >= 0 ? cost[cur] : 0;
        return Math.min(curCost + minCost(cost, cur + 1), curCost + minCost(cost, cur + 2));
    }
}
