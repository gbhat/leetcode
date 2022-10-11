//https://leetcode.com/problems/increasing-triplet-subsequence/

import java.util.Arrays;

public class IncreasingTripletSubsequence2 {
    public boolean increasingTriplet(int[] nums) {
        int[] lis = new int[3];
        Arrays.fill(lis, Integer.MAX_VALUE);		//Important. Since by default array is filled with 0

        for(int i = 0; i < nums.length; i++) {
            int ret = Arrays.binarySearch(lis, nums[i]);
            if (ret < 0)
                ret = -(ret + 1);
            if (ret >= 2)
                return true;
            lis[ret] = nums[i];
        }

        return false;
    }
}


