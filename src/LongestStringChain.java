//https://leetcode.com/problems/longest-string-chain/

import java.util.*;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int[] dp = new int[words.length];
        int max = 0;
        for(int i = 0; i < words.length; i++)
            max = Math.max(max, longestChain(words, dp, i));
        return max;
    }

    private int longestChain(String[] words, int[] dp, int idx) {
        if (idx >= words.length)
            return 0;

        if (dp[idx] > 0)
            return dp[idx];

        int max = 1;
        for(int i = idx + 1; i < words.length; i++) {
            if (isPred(words[idx], words[i]))
                max = Math.max(max, 1 + longestChain(words, dp, i));
        }
        dp[idx] = max;
        return max;
    }

    private boolean isPred(String str1, String str2) {
        if (str2.length() != str1.length() + 1)
            return false;

        boolean isOne = false;
        int j = 0;
        int i = 0;
        if (str1.charAt(0) != str2.charAt(0)) {
            j++;
            isOne = true;
        }
        while(i < str1.length()) {
            if (str1.charAt(i) != str2.charAt(j)) {
                if (isOne)
                    return false;
                isOne = true;
                j++;
            } else {
                i++;
                j++;
            }
        }
        return i == str1.length();
    }
}

