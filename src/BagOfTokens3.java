//https://leetcode.com/problems/bag-of-tokens/

import java.util.Arrays;

public class BagOfTokens3 {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1;
        int score = 0;
        int maxScore = 0;
        while(left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left++];
                score++;
                maxScore = Math.max(score, maxScore);
            }
            else if (power >= tokens[right]) {
                power -= tokens[right--];
                score++;
                maxScore = Math.max(score, maxScore);
            }
            else if (score > 0) {
                score--;
                power += tokens[right--];
            } else
                break;
        }
        return maxScore;
    }
}