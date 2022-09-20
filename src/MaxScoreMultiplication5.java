//https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/

public class MaxScoreMultiplication5 {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[] dp = new int[m + 1];

        for (int idx = m - 1; idx >= 0; idx--) {
            int[] nextRow = dp.clone();
            for (int left = idx; left >= 0; left--) {
                dp[left] = Math.max(multipliers[idx] * nums[left] + nextRow[left + 1],
                        multipliers[idx] * nums[n - 1 - (idx - left)] + nextRow[left]);
            }
        }

        return dp[0];
    }
}