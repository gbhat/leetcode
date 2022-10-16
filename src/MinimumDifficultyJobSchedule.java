//https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/

// Gives TLE
public class MinimumDifficultyJobSchedule {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d)
            return -1;
        return minDiff(jobDifficulty, d, 0);
    }

    private int minDiff(int[] jobs, int d, int idx) {
        if (idx == jobs.length && d == 0)
            return 0;
        if (idx == jobs.length || d == 0)
            return Integer.MAX_VALUE;

        int max = jobs[idx];
        int res = Integer.MAX_VALUE;
        for(int i = idx; i < jobs.length; i++) {
            max = Math.max(jobs[i], max);
            int ret = minDiff(jobs, d - 1, i + 1);
            if (ret != Integer.MAX_VALUE)
                res = Math.min(max + ret, res);
        }

        return res;
    }
}