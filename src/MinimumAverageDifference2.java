//https://leetcode.com/problems/minimum-average-difference/

public class MinimumAverageDifference2 {
    public int minimumAverageDifference(int[] nums) {
        long totalSum = 0;
        for (int num : nums) totalSum += num;

        long curSum = 0;
        long min = Integer.MAX_VALUE;
        int minIdx = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            curSum += nums[i];
            long leftAvg = curSum / (i + 1);
            long rightAvg = (totalSum - curSum) / (nums.length - i - 1);
            long diff = Math.abs(leftAvg - rightAvg);
            if (diff < min) {
                minIdx = i;
                min = diff;
            }
        }

        long lastAvg = totalSum / nums.length;
        if (lastAvg < min)
            minIdx = nums.length - 1;

        return minIdx;
    }
}