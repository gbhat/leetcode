// https://leetcode.com/problems/non-decreasing-array/

//Brute force solution. Check CheckNonDecreasing2.java for efficient one
public class CheckNonDecreasing {
    public boolean checkPossibility(int[] nums) {
        boolean isSmaller = false;
        for(int i = nums.length - 2; i >= 0; i--) {
            for(int j = nums.length - 1; j > i && i >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (isSmaller)
                        return false;
                    isSmaller = true;
                    nums[j] = nums[i];
                    i--;
                }
            }

        }
        return true;
    }
}