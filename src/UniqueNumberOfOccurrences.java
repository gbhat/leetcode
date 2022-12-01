//https://leetcode.com/problems/unique-number-of-occurrences/

import java.util.*;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : arr)
            map.put(n, map.getOrDefault(n, 0) + 1);
        return new HashSet<>(map.values()).size() == map.values().size();
    }
}