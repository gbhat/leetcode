//https://leetcode.com/problems/maximum-profit-in-job-scheduling/

import java.util.Arrays;

// Gives TLE
public class MaximumProfitJobScheduling {
    public int jobScheduling(int[] start, int[] end, int[] profit) {
        int[][] jobs = new int[start.length][3];
        for(int i = 0; i < start.length; i++) {
            jobs[i][0] = start[i];
            jobs[i][1] = end[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (s, t) -> s[0] == t[0] ? s[1] - t[1] : s[0] - t[0]);

        return maxProfit(jobs, 0);
    }

    private int maxProfit(int[][] jobs, int idx) {
        if (idx == jobs.length) return 0;

        int[] task = jobs[idx];
        int pos = Arrays.binarySearch(jobs, idx + 1, jobs.length,
                new int[]{task[1], 0}, (a, b) -> a[0] == b[0] ? a[1] - b[1]: a[0] - b[0]);  // Important step. We search for {task[1], 0}, to get the smallest end first
        if (pos < 0) pos = -pos - 1;
        return Math.max(task[2] + maxProfit(jobs, pos), maxProfit(jobs, idx + 1));
    }
}