//https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/

import java.util.*;

//Problem is tagged with Priority Queue, But using PQ seems very tedious and inefficient
public class MakeArrayZeroSubtractEqual2 {
    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        int prevMin = 0;
        boolean any = false;
        for(int n : nums) {
            if (n != 0) {
                any = true;
                pq.offer(n);
            }
        }

        while(any) {
            int nextMin = pq.poll();
            if (nextMin == prevMin)     // Skip loop, if there are duplicate entries in the PQ
                continue;
            nextMin -= prevMin;         // Since we subtract at every iteration
            any = false;
            count++;
            for(int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[i] -= nextMin;
                }
                if (nums[i] != 0)
                    any = true;
            }
            prevMin += nextMin;
        }

        return count;
    }
}
