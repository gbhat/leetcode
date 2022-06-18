//https://leetcode.com/problems/word-break/

import java.util.*;

// Backtracking. Not accepted. See the DP solution in WordBreak2.java
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return check(s, dict, 0, s.length() - 1);
    }

    private boolean check(String s, Set<String> dict, int low, int high) {
        if (low >= s.length())
            return true;
        for(int i = low; i <= high; i++) {
            String sub = s.substring(low, i + 1);
            if (dict.contains(sub)) {
                if (check(s, dict, i + 1, high))
                    return true;
            }
        }
        return false;
    }
}
