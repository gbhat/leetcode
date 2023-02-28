//https://leetcode.com/problems/edit-distance/

public class LevenshteinDistance {
    public int minDistance(String word1, String word2) {
        if (word1.isEmpty())
            return word2.length();
        if (word2.isEmpty())
            return word1.length();

        return minDist(word1, word2, 0, 0);
    }

    private int minDist(String w1, String w2, int i, int j) {
        if (i == w1.length())
            return w2.length() - j;
        if (j == w2.length())
            return w1.length() - i;

        if (w1.charAt(i) == w2.charAt(j))
            return minDist(w1, w2, i + 1, j + 1);     //If current position is same, no change needed

        return 1 + Math.min(Math.min(minDist(w1, w2, i + 1, j), //Delete
                minDist(w1, w2, i, j + 1)), // Insert
                minDist(w1, w2, i + 1, j + 1)); //Replace
    }
}