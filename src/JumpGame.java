//https://leetcode.com/problems/jump-game/

public class JumpGame {
    public boolean canJump(int[] nums) {
        int curMax = 0;
        for(int i = 0; i < nums.length && curMax < nums.length - 1 && curMax >= i; i++) {
            curMax = Math.max(curMax, i + nums[i]);
        }

        return curMax >= nums.length - 1;
    }
}
