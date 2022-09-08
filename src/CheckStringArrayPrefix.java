//https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/

public class CheckStringArrayPrefix {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(sb.length() <= s.length()) {
            if (sb.indexOf(s) == 0)
                return true;
            if (idx >= words.length)
                return false;
            sb.append(words[idx++]);
        }
        return false;
    }
}
