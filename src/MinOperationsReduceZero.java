//https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/

import java.util.*;

public class MinOperationsReduceZero {
    public int minOperations(int[] nums, int x) {
        int sum  = Arrays.stream(nums).sum();

        int slow = 0;
        int maxLen = -1;
        int curSum = 0;
        for(int fast = 0; fast < nums.length; fast++) {
            curSum += nums[fast];

            while(slow <= fast && curSum > sum - x)
                curSum -= nums[slow++];

            if (curSum == sum - x)
                maxLen = Math.max(maxLen, fast - slow + 1);
        }

        return maxLen == -1 ? maxLen : nums.length - maxLen;
    }
}
