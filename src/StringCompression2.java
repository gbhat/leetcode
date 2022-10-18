//https://leetcode.com/problems/string-compression/

public class StringCompression2 {
    public int compress(char[] chars) {

        if(chars.length == 0)
            return 0;

        int resIdx = 0;
        for(int i = 0; i < chars.length; i++) {
            int sublen = 1;
            while(i < chars.length - 1 && chars[i] == chars[i + 1]) {
                sublen++;
                i++;
            }
            chars[resIdx++] = chars[i];
            if (sublen > 1) {
                String sublenStr = String.valueOf(sublen);
                for(char c : sublenStr.toCharArray())
                    chars[resIdx++] = c;
            }
        }

        return resIdx;
    }
}