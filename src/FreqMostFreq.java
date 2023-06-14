//https://leetcode.com/problems/frequency-of-the-most-frequent-element/
import java.util.Arrays;

//Brute force approach. Leads to TLE
public class FreqMostFreq {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int res = 1;
        for(int i = 0; i < nums.length; i++) {
            long sum = nums[i];
            for(int j = i - 1; j >= 0; j--) {
                sum += nums[j];
                long total = (long) nums[i] * (i - j + 1);        //Total needed if nums[i] is repated (i - j + 1) times
                if (sum + k >= total)             // If adding k to sum is greater than total expected, then we have frequency of i - j + 1
                    res = Math.max(res, i - j + 1);
            }
        }
        return res;
    }
}