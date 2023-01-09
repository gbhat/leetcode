//https://leetcode.com/problems/maximum-ice-cream-bars/

import java.util.Arrays;

public class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int total = 0;
        int idx = 0;
        while(idx < costs.length && costs[idx] <= coins) {
            coins -= costs[idx];
            total++;
            idx++;
        }
        return total;
    }
}