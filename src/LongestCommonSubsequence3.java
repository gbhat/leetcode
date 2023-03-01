//https://leetcode.com/problems/longest-common-subsequence

public class LongestCommonSubsequence3 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for(int i = 1; i <= text1.length(); i++) {
            for(int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        printLCS(text1, dp, dp.length - 1, dp[0].length - 1);

        return dp[text1.length()][text2.length()];
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

    private void printLCS(String text, int[][] dp, int i, int j) {
        if (i == 0 || j == 0 )
            return;
        if (dp[i][j] == dp[i - 1][j - 1] + 1)
            printLCS(text, dp, i - 1, j - 1);
        else if (dp[i][j] == dp[i - 1][j])
            printLCS(text, dp, i - 1, j);
        else
            printLCS(text, dp, i, j - 1);

        if (dp[i][j] > 0)
            System.out.print(text.charAt(i - 1));
    }
}