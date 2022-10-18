//https://leetcode.com/problems/zigzag-conversion/

import java.util.Arrays;
import java.util.stream.Collectors;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() == 0)
            return s;

        StringBuilder[] sb = new StringBuilder[numRows];

        for(int i = 0; i < numRows; i++)
            sb[i] = new StringBuilder();

        boolean isInc = false;
        int curIdx = 0;
        for(int i = 0; i < s.length(); i++) {
            sb[curIdx].append(s.charAt(i));
            if (curIdx == 0 || curIdx == numRows - 1)
                isInc = !isInc;
            curIdx += isInc ? 1 : -1;
        }

        return Arrays.stream(sb).map(t -> t.toString()).collect(Collectors.joining(""));
    }
}
