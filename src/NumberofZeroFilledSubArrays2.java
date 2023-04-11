//https://leetcode.com/problems/number-of-zero-filled-subarrays/

public class NumberofZeroFilledSubArrays2 {
    public long zeroFilledSubarray(int[] nums) {
        long total = 0;
        int i = 0;
        while(i < nums.length) {
            if (nums[i] == 0) {
                int count = 1;
                while(i < nums.length && nums[i] == 0) {
                    total += count;
                    count++;
                    i++;
                }
            } else
                i++;
        }
        return total;
    }

    private long getCnt(int count) {
        long total = 0;
        for(int i = 1; i <= count; i++)
            total += i;
        return total;
    }
}