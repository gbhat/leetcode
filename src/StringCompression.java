//https://leetcode.com/problems/string-compression/

public class StringCompression {
    public int compress(char[] chars) {

        if(chars.length == 0)
            return 0;

        int sublen = 1;
        int i = 0;
        int resIdx = 0;
        for(i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1])
                sublen ++;
            else {
                chars[resIdx++] = chars[i];

                if (sublen > 1) {
                    String sublenStr = String.valueOf(sublen);
                    for(char c : sublenStr.toCharArray())
                        chars[resIdx++] = c;
                }
                sublen = 1;
            }
        }

        chars[resIdx++] = chars[i];
        if (sublen > 1) {
            String sublenStr = String.valueOf(sublen);
            for(char c : sublenStr.toCharArray())
                chars[resIdx++] = c;
        }

        return resIdx;
    }
}
