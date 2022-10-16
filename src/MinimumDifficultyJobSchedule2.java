//https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/

import java.util.*;

public class MinimumDifficultyJobSchedule2 {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d)
            return -1;

        int[][] lookup = new int[d + 1][jobDifficulty.length];
        for(int[] arr : lookup)
            Arrays.fill(arr, -1);

        return minDiff(jobDifficulty, d, 0, lookup);
    }

    private int minDiff(int[] jobs, int d, int idx, int[][] lookup) {
        if (idx == jobs.length && d == 0)
            return 0;

        if (idx == jobs.length || d == 0)
            return Integer.MAX_VALUE;

        if (lookup[d][idx] != -1)
            return lookup[d][idx];

        int max = jobs[idx];
        int res = Integer.MAX_VALUE;
        for(int i = idx; i < jobs.length; i++) {
            max = Math.max(jobs[i], max);
            int ret = minDiff(jobs, d - 1, i + 1, lookup);
            if (ret != Integer.MAX_VALUE)
                res = Math.min(max + ret, res);
        }

        return lookup[d][idx] = res;
    }
}