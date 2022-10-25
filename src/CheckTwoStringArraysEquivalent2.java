//https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/

public class CheckTwoStringArraysEquivalent2 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, j = 0;
        int idx1 = 0, idx2 = 0;
        while(idx1 < word1.length && idx2 < word2.length) {
            if (word1[idx1].charAt(i) != word2[idx2].charAt(j))
                return false;

            i++;
            if (i >= word1[idx1].length()) {
                idx1++;
                i = 0;
            }

            j++;
            if (j >= word2[idx2].length()) {
                idx2++;
                j = 0;
            }
        }

        return idx1 == word1.length && idx2 == word2.length;
    }
}