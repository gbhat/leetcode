//https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/

import java.util.*;

// This implementation is caching the results using a HashMap.
// Still this results in TLE for many inputs probably because of hash collisions.
// Tested with different implementation of hashCode and different results are observed.
public class MaxScoreMultiplication3 {
    class Pair {
        int left, idx;
        public Pair(int left, int idx) {
            this.left = left;
            this.idx = idx;
        }
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return left == pair.left && idx == pair.idx;
        }
/*
        // With this implementation of hashCode 15 test cases pass.
        public int hashCode() {
            return left + idx;
        }
*/
/*
        // With this implementation of hashCode 19 test cases pass.
        public int hashCode() {
            return Objects.hash(left, idx);
        }
*/
        // With this implementation of hashCode 22 test cases pass
        public int hashCode() {
            int result = 17;
            result = 31 * result + left;
            result = 31 * result + idx;
            return result;
        }
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        HashMap<Pair, Integer> map = new HashMap<>();
        return maxScore(nums, multipliers, 0, 0, map);
    }

    private int maxScore(int[] nums, int[] multipliers, int left, int idx, HashMap<Pair, Integer> map) {
        if (left >= nums.length || idx >= multipliers.length)
            return 0;
        Pair pair = new Pair(left, idx);
        if (map.containsKey(pair))
            return map.get(pair);
        int leftProd = multipliers[idx] * nums[left];
        int rightProd = multipliers[idx] * nums[nums.length - 1 - (idx - left)];
        int max =  Math.max(leftProd + maxScore(nums, multipliers, left + 1, idx + 1, map),
                rightProd + maxScore(nums, multipliers, left, idx + 1, map));
        map.put(pair, max);
        return max;
    }
}