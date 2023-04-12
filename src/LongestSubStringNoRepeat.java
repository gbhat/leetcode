//https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringNoRepeat {
    public int lengthOfLongestSubstring(String s) {
        int low = 0, high = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(high < s.length()) {
            if (map.containsKey(s.charAt(high))) {
                map.remove(s.charAt(low));
                low++;
            } else {
                result = Math.max(result, high - low + 1);
                map.put(s.charAt(high), map.getOrDefault(s.charAt(high), 0) + 1);
                high++;
            }
        }
        return result;
    }
}