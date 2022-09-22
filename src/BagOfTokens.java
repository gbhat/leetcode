//https://leetcode.com/problems/bag-of-tokens/

import java.util.Arrays;

// Leads to TLE
public class BagOfTokens {
    int max = 0;
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        bag(tokens, power, 0, tokens.length - 1, 0);
        return max;
    }

    private void bag(int[] tokens, int power, int left, int right, int score) {
        System.out.println(left + " " + right + " " + score);
        max = Math.max(score, max);
        if (left > right)
            return;
        if (power >= tokens[left])
            bag(tokens, power - tokens[left], left + 1, right, score + 1);
        if (power >= tokens[right])
            bag(tokens, power - tokens[right], left, right - 1, score + 1);
        if (score > 0)
            bag(tokens, power + tokens[right], left, right - 1, score - 1);
    }
}