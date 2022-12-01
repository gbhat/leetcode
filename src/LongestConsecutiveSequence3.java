//https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.*;

public class LongestConsecutiveSequence3 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        Set<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            set.add(n);
        }

        int max = 1;
        for(int n : set) {
            if (!set.contains(n - 1)) {  // If set contains n - 1, we will skip this loop since we will loop from n - 1
                int count = 1;
                while(set.contains(n + 1)) {
                    count++;
                    n = n + 1;
                }
                max = Math.max(count, max);
            }
        }

        return max;
    }
}


