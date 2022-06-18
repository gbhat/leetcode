//https://leetcode.com/problems/climbing-stairs/

// Recursive solution. Not accepted. Check ClimbingStairs2.java for DP solution
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2)
            return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
