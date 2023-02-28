//https://leetcode.com/problems/edit-distance/

public class LevenshteinDistance2 {
    public int minDistance(String word1, String word2) {
        if (word1.isEmpty())
            return word2.length();
        if (word2.isEmpty())
            return word1.length();

        int[][] dp = new int[word1.length()][word2.length()];
        return minDist(word1, word2, 0, 0, dp);
    }

    private int minDist(String w1, String w2, int i, int j, int[][] dp) {
        if (i == w1.length())
            return w2.length() - j;
        if (j == w2.length())
            return w1.length() - i;

        if (dp[i][j] != 0)
            return dp[i][j];
        if (w1.charAt(i) == w2.charAt(j))
            return dp[i][j] = minDist(w1, w2, i + 1, j + 1, dp);

        return dp[i][j] = 1 + Math.min(Math.min(minDist(w1, w2, i + 1, j, dp), //Delete
                        minDist(w1, w2, i, j + 1, dp)), // Insert
                minDist(w1, w2, i + 1, j + 1, dp)); //Replace
    }
}