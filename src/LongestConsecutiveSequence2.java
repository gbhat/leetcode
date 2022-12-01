//https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.HashMap;

public class LongestConsecutiveSequence2 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, 1);
        }

        int max = 1;
        for(int n : map.keySet()) {
            if (!map.containsKey(n - 1)) {  // If map contains n - 1, we will skip this loop since we will loop from n - 1
                while(map.containsKey(n + 1)) {
                    map.put(n + 1, map.get(n) + 1);
                    max = Math.max(map.get(n + 1), max);
                    n = n + 1;
                }
            }
        }

        return max;
    }
}

