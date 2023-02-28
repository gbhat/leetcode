//https://leetcode.com/problems/edit-distance/

public class LevenshteinDistance3 {
    public int minDistance(String word1, String word2) {
        if (word1.isEmpty())
            return word2.length();
        if (word2.isEmpty())
            return word1.length();

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++)
            dp[i][0] = i;
        for (int j = 0; j <= word2.length(); j++)
            dp[0][j] = j;


        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
                    //Since it is bottom up, we are considering in the ascending order of indexes.
                    //Insert means plus 1 to j, delete means plus 1 to i, replace means plus 1 to both i and j. 
                    //above sequence is delete, insert and replace. 
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}