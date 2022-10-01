//https://leetcode.com/problems/decode-ways/

import java.util.*;

public class DecodeWays2 {
    public int numDecodings(String s) {
        Map<String, Integer> map = new HashMap<>();
        return numDec(s, map);
    }

    private int numDec(String s, Map<String, Integer> map) {
        if (map.containsKey(s))
            return map.get(s);

        if (s.length() == 0)
            return 1;

        int ret = 0;
        for(int i = 1; i <= 9; i++) {
            if (s.startsWith(String.valueOf(i))) {
                ret = numDec(s.substring(1), map);
            }
        }

        for(int i = 10; i <= 26; i++) {
            if (s.startsWith(String.valueOf(i))) {
                ret += numDec(s.substring(2), map);
            }
        }

        map.put(s, ret);

        return ret;
    }
}