//https://leetcode.com/problems/find-original-array-from-doubled-array/

import java.util.*;

public class FindOrigArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 == 1)
            return new int[0];
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for(int no : changed)
            map.put(no, map.getOrDefault(no, 0) + 1);

        int[] orig = new int[n / 2];
        int idx = 0;
        while(map.size() > 0) {
            Map.Entry<Integer, Integer> entry = map.firstEntry();
            int halfVal = entry.getKey() / 2;
            if (!map.containsKey(halfVal) || entry.getKey() % 2 == 1)
                return new int[0];
            orig[idx++] = halfVal;
            if (entry.getValue() == 1)
                map.remove(entry.getKey());
            else
                map.put(entry.getKey(), entry.getValue() - 1);
            if (map.get(halfVal) == 1)
                map.remove(halfVal);
            else
                map.put(halfVal, map.get(halfVal) - 1);
        }

        return idx == n / 2? orig : new int[0];
    }
}