//https://leetcode.com/problems/frequency-of-the-most-frequent-element/
import java.util.Arrays;

public class FreqMostFreq3 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for(int i = 1; i < n; i++)
            sum[i] = sum[i - 1] + nums[i];

        int res = 1;
        for(int i = 0; i < n; i++) {
            res = Math.max(res, count(nums, sum, i, k));
        }
        return res;
    }

    private int count(int[] nums, int[] sum, int i, int k) {
        int low = 0, high = i;
        int res = 0;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int lhs = (i - mid + 1) * nums[i];
            int rhs = mid == 0 ? sum[i] + k : sum[i] - sum[mid - 1] + k;
            if (lhs <= rhs) {
                res = i - mid + 1;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return res;
    }
}

