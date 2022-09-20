//https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/

// This solution leads to TLE
public class MaxScoreMultiplication {
    public int maximumScore(int[] nums, int[] multipliers) {
        return maxScore(nums, multipliers, 0, nums.length - 1, 0);
    }

    private int maxScore(int[] nums, int[] multipliers, int left, int right, int idx) {
        if (left > right || idx >= multipliers.length)
            return 0;
        int leftProd = multipliers[idx] * nums[left];
        int rightProd = multipliers[idx] * nums[right];
        return Math.max(leftProd + maxScore(nums, multipliers, left + 1, right, idx + 1),
                rightProd + maxScore(nums, multipliers, left, right - 1, idx + 1));
    }
}