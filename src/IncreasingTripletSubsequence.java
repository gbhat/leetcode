//https://leetcode.com/problems/increasing-triplet-subsequence/

import java.util.Arrays;

// Uses DP logic of Longest Increasing Subsequence. This gives TLE
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i] && dp[j] < dp[i] + 1) {
                    dp[j] = dp[i] + 1;
                    if (dp[j] >= 3)
                        return true;
                }

            }
        }
        return false;
    }
}
