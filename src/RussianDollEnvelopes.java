//https://leetcode.com/problems/russian-doll-envelopes/

import java.util.Arrays;

// Longest Increasing Order approach. This does not work for largest inputs.
// Check RussianDollEnvelopes2.java
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envs) {
        Arrays.sort(envs, (a, b) -> a[0] - b[0]);

        int[] lis = new int[envs.length];
        Arrays.fill(lis, 1);

        int max = 1;
        for(int  i = 0; i < envs.length; i++) {
            for(int j = i + 1; j < envs.length; j++) {
                if (lis[j] < lis[i] + 1 && envs[i][0] < envs[j][0] && envs[i][1] < envs[j][1]) {
                    lis[j] = lis[i] + 1;
                    max = Math.max(lis[j], max);
                }
            }
        }
        return max;
    }
}