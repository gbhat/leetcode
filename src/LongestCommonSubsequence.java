//https://leetcode.com/problems/longest-common-subsequence

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2, 0, 0);
    }

    private int lcs(String t1, String t2, int i, int j) {
        if (i >= t1.length() || j >= t2.length())
            return 0;

        if (t1.charAt(i) == t2.charAt(j))
            return 1 + lcs(t1, t2, i + 1, j + 1);

        return Math.max(lcs(t1, t2, i + 1, j), lcs(t1, t2, i, j + 1));
    }
}