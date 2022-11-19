//https://leetcode.com/problems/ugly-number/

import java.util.*;


// This leads to TLE
// We are iterating till n is 1. That is not necessary. Once we go above 2, 3, 5 we can return false.
public class UglyNumber {
    public boolean isUgly(int n) {
        if (n <= 0)
            return false;
        if (n <= 3)
            return true;
        Set<Integer> set = new HashSet<>();
        int cur = 2;
        while(n != 1) {
            if (n % cur == 0) {
                set.add(cur);
                n = n / cur;
            } else
                cur++;
        }
        set.removeAll(Arrays.asList(2, 3, 5));
        return set.size() == 0;
    }
}