//https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/

public class CheckStringArrayPrefix2 {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(sb.length() < s.length() && idx < words.length) {
            sb.append(words[idx++]);
        }
        return sb.toString().equals(s);
    }
}