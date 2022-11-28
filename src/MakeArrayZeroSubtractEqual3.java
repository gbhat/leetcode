//https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/

import java.util.PriorityQueue;

// Fastest solution
public class MakeArrayZeroSubtractEqual3 {
    public int minimumOperations(int[] nums) {
        int[] count = new int[101]; // Since 100 is max in Constraints
        for(int n : nums)
            count[n] = 1;
        int distinct = 0;
        for(int i = 1; i < 101; i++)
            distinct += count[i];
        return distinct;
    }
}
