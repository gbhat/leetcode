//https://leetcode.com/problems/jump-game-ii/

public class JumpGame_II {
    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curMax = 0;
        for (int i = 0; i < nums.length - 1 && curEnd < nums.length - 1; i++) {
            curMax = Math.max(curMax, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curMax;
            }
        }
        return jumps;
    }
}

