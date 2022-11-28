//https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/

public class MakeArrayZeroSubtractEqual {
    public int minimumOperations(int[] nums) {
        int count = 0;
        while(true) {
            int min = Integer.MAX_VALUE;
            for(int n : nums) {
                if (n != 0)
                    min = Math.min(min, n);
            }
            if (min == Integer.MAX_VALUE)
                break;

            count++;
            for(int i = 0; i < nums.length; i++)
                nums[i] = nums[i] == 0 ? 0 : nums[i] - min;
        }
        return count;
    }
}
