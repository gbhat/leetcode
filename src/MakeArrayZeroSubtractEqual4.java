//https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/

import java.util.Arrays;

// Shortest solution
public class MakeArrayZeroSubtractEqual4 {
    public int minimumOperations(int[] nums) {
        return (int) Arrays.stream(nums).filter(t -> t != 0).distinct().count();
    }
}