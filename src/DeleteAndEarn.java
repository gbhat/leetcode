//https://leetcode.com/problems/delete-and-earn/

import java.util.*;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int n : nums)
            max = Math.max(max, n);

        int[] sum = new int[max + 1];
        for(int n : nums)
            sum[n] += n;

        HashMap<Integer, Integer> lookup = new HashMap<>();

        return max(sum, lookup, max);
    }

    private int max(int[] sum, HashMap<Integer, Integer> lookup, int idx) {
        if (idx < 0)
            return 0;

        if (lookup.containsKey(idx))
            return lookup.get(idx);


        int res = Math.max(sum[idx] + max(sum, lookup, idx - 2), max(sum, lookup, idx - 1));
        lookup.put(idx, res);
        return res;
    }
}