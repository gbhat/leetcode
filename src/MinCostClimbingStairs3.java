//https://leetcode.com/problems/min-cost-climbing-stairs/

public class MinCostClimbingStairs3 {
    public int minCostClimbingStairs(int[] cost) {
        int prev2 = cost[0];
        int prev1 = cost[1];

        int total = 0;
        for(int i = 2; i < cost.length; i++) {
            total = Math.min(prev1, prev2) + cost[i];
            prev2 = prev1;
            prev1 = total;
        }

        return Math.min(prev1, prev2);
    }
}