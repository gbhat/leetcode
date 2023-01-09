//https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/

import java.util.*;

public class MinRoundsToCompleteAllTasks3 {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int idx = 0;
        int count = 0;
        while(idx < tasks.length) {
            if (idx < tasks.length - 2 && tasks[idx] == tasks[idx + 1] && tasks[idx] == tasks[idx + 2]) {
                count++;
                idx += 3;
            } else if (idx < tasks.length - 1 && tasks[idx] == tasks[idx + 1]) {
                count++;
                idx += 2;
            } else if (idx > 0 && tasks[idx] == tasks[idx - 1] && count > 0) {
                count++;
                idx++;
            } else
                return -1;
        }
        return count;
    }
}