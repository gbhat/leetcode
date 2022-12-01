//https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.*;

// This gives TLE
// For every number, we iterate the map if we find n + 1 in the map.
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            if (map.containsKey(n - 1))
                map.put(n, map.get(n - 1) + 1);
            else
                map.put(n, 1);

            while(map.containsKey(n + 1)) {
                map.put(n + 1, map.get(n) + 1);
                n = n + 1;
            }
        }

        int max = 0;
        for(int v : map.values())
            max = Math.max(v, max);
        return max;
    }
}

