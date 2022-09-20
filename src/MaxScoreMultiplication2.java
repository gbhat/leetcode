//https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/

// This solution leads to TLE. This is re-written to avoid left and right parameter which helps in memoization.
public class MaxScoreMultiplication2 {
    public int maximumScore(int[] nums, int[] multipliers) {
        return maxScore(nums, multipliers, 0, 0);
    }

    private int maxScore(int[] nums, int[] multipliers, int left, int idx) {
        if (left >= nums.length || idx >= multipliers.length)
            return 0;
        int leftProd = multipliers[idx] * nums[left];
        int rightProd = multipliers[idx] * nums[nums.length - 1 - (idx - left)];
        return Math.max(leftProd + maxScore(nums, multipliers, left + 1, idx + 1),
                rightProd + maxScore(nums, multipliers, left, idx + 1));
    }
}