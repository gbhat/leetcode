//https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/

import java.util.*;

public class MinRoundsToCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : tasks)
            map.put(t, map.getOrDefault(t, 0) + 1);

        int rounds = 0;
        for(int freq : map.values()) {
            if (freq < 2)
                return -1;
            rounds += (int) Math.ceil((double)freq / 3);
        }
        return rounds;
    }
}