//https://leetcode.com/problems/set-mismatch/

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] lookup = new int[nums.length + 1];
        for(int n : nums) {
            lookup[n]++;
        }

        int dup = -1;
        int missing = -1;
        for(int i = 1; i < lookup.length; i++) {
            if (lookup[i] == 2)
                dup = i;
            if (lookup[i] == 0)
                missing = i;
        }

        return new int[]{dup, missing};
    }
}