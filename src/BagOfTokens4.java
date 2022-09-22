//https://leetcode.com/problems/bag-of-tokens/

import java.util.Arrays;

public class BagOfTokens4 {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1;
        int points = 0, ans = 0;
        while (left <= right && (power >= tokens[left] || points > 0)) {
            while (left <= right && power >= tokens[left]) {
                power -= tokens[left++];
                points++;
            }

            ans = Math.max(ans, points);
            if (left <= right && points > 0) {
                power += tokens[right--];
                points--;
            }
        }

        return ans;
    }
}