//https://leetcode.com/problems/set-mismatch/

public class SetMismatch3 {
    public int[] findErrorNums(int[] nums) {
        int xor = 0, xor0 = 0, xor1 = 0;
        for (int n: nums)
            xor ^= n;
        for (int i = 1; i <= nums.length; i++)
            xor ^= i;
        int rightMostBit = xor & -xor;
        for (int n: nums) {
            if ((n & rightMostBit) != 0)
                xor1 ^= n;
            else
                xor0 ^= n;
        }
        for (int i = 1; i <= nums.length; i++) {
            if ((i & rightMostBit) != 0)
                xor1 ^= i;
            else
                xor0 ^= i;
        }
        for (int num : nums) {
            if (num == xor0)
                return new int[]{xor0, xor1};
        }
        return new int[]{xor1, xor0};
    }
}