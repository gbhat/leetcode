//https://leetcode.com/problems/longest-common-subsequence

public class LongestCommonSubsequence2 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        return lcs(text1, text2, 0, 0, dp);
    }

    private int lcs(String t1, String t2, int i, int j, int[][] dp) {
        if (i >= t1.length() || j >= t2.length())
            return 0;

        if (dp[i][j] != 0)
            return dp[i][j];

        if (t1.charAt(i) == t2.charAt(j))
            return dp[i][j] = 1 + lcs(t1, t2, i + 1, j + 1, dp);

        return dp[i][j] = Math.max(lcs(t1, t2, i + 1, j, dp), lcs(t1, t2, i, j + 1, dp));
    }
}