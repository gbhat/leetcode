//https://leetcode.com/problems/longest-increasing-subsequence/

// Recursive solution. This leads to timeout exception for large inputs.
public class LongestIncreasingSubsequence {
    int max = 0;
    public int lengthOfLIS(int[] nums) {
        max = 0;
        for(int i = 0; i < nums.length; i++)
            lis(nums, i, 1);
        return max;
    }

    private void lis(int[] nums, int idx, int count) {
        max = Math.max(max, count);

        if (idx >= nums.length)
            return;

        for(int i = idx + 1; i < nums.length; i++) {
            if (nums[i] > nums[idx])
                lis(nums, i, count + 1);
        }
    }
}
