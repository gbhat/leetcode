//https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/

import java.util.HashMap;

public class MaxScoreMultiplication4 {
    public int maximumScore(int[] nums, int[] multipliers) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        return maxScore(nums, multipliers, 0, 0, map);
    }

    private int maxScore(int[] nums, int[] multipliers, int left, int idx, HashMap<Integer, HashMap<Integer, Integer>> map) {
        if (left >= nums.length || idx >= multipliers.length)
            return 0;
        if (map.containsKey(left) && map.get(left).containsKey(idx))
            return map.get(left).get(idx);
        int leftProd = multipliers[idx] * nums[left];
        int rightProd = multipliers[idx] * nums[nums.length - 1 - (idx - left)];
        int max =  Math.max(leftProd + maxScore(nums, multipliers, left + 1, idx + 1, map),
                rightProd + maxScore(nums, multipliers, left, idx + 1, map));
        map.putIfAbsent(left, new HashMap<Integer, Integer>());
        map.get(left).put(idx, max);
        return max;
    }
}