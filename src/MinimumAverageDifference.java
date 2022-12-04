//https://leetcode.com/problems/minimum-average-difference/

public class MinimumAverageDifference {
    public int minimumAverageDifference(int[] nums) {
        long sum = 0;
        long[] sumArr = new long[nums.length];
        for(int i = 0; i < nums.length; i++) {
            sumArr[i] = sum + nums[i];
            sum = sumArr[i];
        }
        long min = Integer.MAX_VALUE;
        int minIdx = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            long leftAvg = sumArr[i] / (i + 1);
            long rightAvg = (sumArr[nums.length - 1] - sumArr[i]) / (nums.length - i - 1);
            long diff = Math.abs(leftAvg - rightAvg);
            if (diff < min) {
                minIdx = i;
                min = diff;
            }
        }

        long lastAvg = sumArr[nums.length - 1] / nums.length;
        if (lastAvg < min) {
            min = lastAvg;
            minIdx = nums.length - 1;
        }

        return minIdx;
    }
}
