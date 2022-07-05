//https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums)
            set.add(n);

        int maxLen = 0;
        for(int n : set) {
            if (!set.contains(n - 1)) {
                int cur = n;
                int len = 0;

                while(set.contains(cur)) {
                    cur = cur + 1;
                    len++;
                }
                maxLen = Math.max(len, maxLen);
            }
        }
        return maxLen;
    }
}