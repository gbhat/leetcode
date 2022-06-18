//https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.*;

public class LongestSubStringNoRepeat2 {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0, left = 0; right < s.length(); right++) {
            left = Math.max(map.getOrDefault(s.charAt(right), left), left);
            longest = Math.max(longest, right - left + 1);
            map.put(s.charAt(right), right + 1);
        }

        return longest;
    }
}
