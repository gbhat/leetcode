//https://leetcode.com/problems/bag-of-tokens/

import java.util.*;

public class BagOfTokens2 {
    int max = 0;
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        bag(tokens, power, 0, tokens.length - 1, 0, map);
        return max;
    }

    private void bag(int[] tokens, int power, int left, int right, int score, HashMap<Integer, HashMap<Integer, Integer>> map) {
        max = Math.max(score, max);
        if (map.containsKey(left) && map.get(left).containsKey(right))
            return;
        if (left > right)
            return;
        if (power >= tokens[left])
            bag(tokens, power - tokens[left], left + 1, right, score + 1, map);
        if (power >= tokens[right])
            bag(tokens, power - tokens[right], left, right - 1, score + 1, map);
        if (score > 0)
            bag(tokens, power + tokens[right], left, right - 1, score - 1, map);
        map.putIfAbsent(left, new HashMap<Integer, Integer>());
        map.get(left).put(right, 0);
    }
}

