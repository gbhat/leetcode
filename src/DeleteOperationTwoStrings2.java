//https://leetcode.com/problems/delete-operation-for-two-strings/

public class DeleteOperationTwoStrings2 {
    public int minDistance(String word1, String word2) {
        int[][] lookup = new int[word1.length() + 1][word2.length() + 1];
        return minDist(word1, word2, 0, 0, lookup);
    }
    private int minDist(String word1, String word2, int idx1, int idx2, int[][] lookup) {
        if (lookup[idx1][idx2] != 0)
            return lookup[idx1][idx2];
        if (idx1 >= word1.length() && idx2 >= word2.length())
            return 0;
        else if (idx1 >= word1.length())
            return word2.length() - idx2;
        else if (idx2 >= word2.length())
            return word1.length() - idx1;
        else if (word1.charAt(idx1) == word2.charAt(idx2))
            return minDist(word1, word2, idx1 + 1, idx2 + 1, lookup);
        else {
            int ret = Math.min(1 + Math.min(minDist(word1, word2, idx1 + 1, idx2, lookup), minDist(word1, word2, idx1, idx2 + 1, lookup)),
                    2 + minDist(word1, word2, idx1 + 1, idx2 + 1, lookup));
            lookup[idx1][idx2] = ret;
            return ret;
        }
    }
}