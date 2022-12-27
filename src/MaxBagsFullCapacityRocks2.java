//https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks

import java.util.Arrays;

public class MaxBagsFullCapacityRocks2 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] cap = new int[capacity.length];
        for(int i = 0; i < capacity.length; i++)
            cap[i] = capacity[i] - rocks[i];
        Arrays.sort(cap);
        int i;
        for(i = 0; i < capacity.length && additionalRocks >= cap[i]; i++)
            additionalRocks -= cap[i];
        return i;
    }
}