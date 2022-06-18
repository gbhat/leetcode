//https://leetcode.com/problems/russian-doll-envelopes/

import java.util.Arrays;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envs) {
        Arrays.sort(envs, (a, b) -> a[0] != b[0] ? a[0]-b[0] : b[1] - a[1]);

        int[] lookup = new int[envs.length];
        int total = 0;
        for(int i = 0; i  < envs.length; i++) {
            int loc = Arrays.binarySearch(lookup, 0, total, envs[i][1]);
            if (loc < 0) loc = -loc-1;
            if (loc == total) total++;
            lookup[loc] = envs[i][1];
        }
        return total;
    }
}

