//https://leetcode.com/problems/longest-string-chain/

import java.util.*;

public class LongestStringChain2 {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;

        for(String word : words) {
            map.put(word, 1);
            StringBuilder sb = new StringBuilder(word);
            for(int i = 0; i < word.length(); i++) {
                char ch = sb.charAt(i);
                String s = sb.deleteCharAt(i).toString();
                if(map.getOrDefault(s, 0) + 1 > map.get(word))
                    map.put(word, map.getOrDefault(s, 0) + 1);
                sb.insert(i, ch);
            }
            max = Math.max(max, map.get(word));
        }
        return max;
    }
}
