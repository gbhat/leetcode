//https://leetcode.com/problems/longest-increasing-subsequence/

import java.util.Arrays;

public class LongestIncreasingSubsequence4 {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];

        int size = 0;
        for (int n : nums) {
            int ret = Arrays.binarySearch(tails, 0, size, n);
            if (ret >= 0)
                continue;
            ret = -(ret + 1);
            tails[ret] = n;
            if (ret == size) size++;
        }

        return size;
    }

    public static void main(String[] args){
        int[] nums = {0, 1, 0, 3, 2, 3};
        System.out.println(new LongestIncreasingSubsequence4().lengthOfLIS(nums));
    }
}