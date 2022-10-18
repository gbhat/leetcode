//https://leetcode.com/problems/zigzag-conversion/

import java.util.Arrays;
import java.util.stream.Collectors;

public class ZigzagConversion2 {
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < sb.length; i++)
            sb[i] = new StringBuilder();

        int idx = 0;
        for(int i = 0; i < s.length();) {
            for(int j = 0; j < numRows && i < s.length(); j++, i++)
                sb[j].append(s.charAt(i));
            for(int j = numRows - 2; j > 0 && i < s.length(); j--, i++)
                sb[j].append(s.charAt(i));
        }

        return Arrays.stream(sb).map(t -> t.toString()).collect(Collectors.joining(""));
    }
}
