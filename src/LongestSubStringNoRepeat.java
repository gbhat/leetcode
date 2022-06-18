//https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class LongestSubStringNoRepeat {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int[] lookup = new int[128];

        for (int right = 0, left = 0; right < s.length(); right++) {
            left = Math.max(lookup[s.charAt(right)], left);
            longest = Math.max(longest, right - left + 1);
            lookup[s.charAt(right)] = right + 1;
        }

        return longest;
    }
}
