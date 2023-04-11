//https://leetcode.com/problems/number-of-zero-filled-subarrays/

public class NumberofZeroFilledSubArrays {
    public long zeroFilledSubarray(int[] nums) {
        long total = 0;
        int i = 0;
        while(i < nums.length) {
            if (nums[i] == 0) {
                int count = 1;
                while(i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    count++;
                    i++;
                }
                total += getCnt(count);
            }
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