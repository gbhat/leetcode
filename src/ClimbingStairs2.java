//https://leetcode.com/problems/climbing-stairs/

public class ClimbingStairs2 {
    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2)
            return n;

        int from_last_step = 1;
        int from_last_2_step = 2;
        int total = 0;
        for(int i = 2; i < n; i++) {
            total = from_last_step + from_last_2_step;
            from_last_step = from_last_2_step;
            from_last_2_step = total;
        }

        return total;
    }
}
