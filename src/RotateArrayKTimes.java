//https://leetcode.com/problems/rotate-array/

// This uses O(n) extra space
public class RotateArrayKTimes {
    public void rotate(int[] nums, int k) {
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int next = (i + k) % nums.length;
            res[next] = nums[i];
        }

        for(int i = 0; i < nums.length; i++)
            nums[i] = res[i];
    }
}

