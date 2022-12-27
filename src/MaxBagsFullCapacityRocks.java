//https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks

import java.util.Arrays;

// This modifies capacity input array
public class MaxBagsFullCapacityRocks {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for(int i = 0; i < capacity.length; i++)
            capacity[i] -= rocks[i];
        Arrays.sort(capacity);
        int idx = 0;
        while(capacity[idx] == 0)
            idx++;
        while(idx < capacity.length && additionalRocks > 0) {
            if (capacity[idx] <= additionalRocks)
                additionalRocks -= capacity[idx++];
            else break;
        }
        return idx;
    }
}