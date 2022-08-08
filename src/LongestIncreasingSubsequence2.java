//https://leetcode.com/problems/longest-increasing-subsequence/

import java.util.Arrays;

public class LongestIncreasingSubsequence2 {
    public int lengthOfLIS(int[] nums) {
        int max = 1;
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i] && lis[j] < lis[i] + 1) {
                    lis[j] = lis[i] + 1;
                    max = Math.max(max, lis[j]);
                }
            }
        }

        return max;
    }
}