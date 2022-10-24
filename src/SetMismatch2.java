//https://leetcode.com/problems/set-mismatch/

public class SetMismatch2 {
    public int[] findErrorNums(int[] nums) {
        int dup = -1, missing = -1;
        for(int n : nums) {
            int idx = Math.abs(n) - 1;
            if (nums[idx] < 0)
                dup = Math.abs(n);
            else
                nums[idx] *= -1;
        }

        for(int i = 0; i < nums.length; i++)
            if(nums[i] > 0)
                missing = i + 1;

        return new int[]{dup, missing};
    }
}