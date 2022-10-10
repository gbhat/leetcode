//https://leetcode.com/problems/break-a-palindrome/

public class BreakPalindrome {
    public String breakPalindrome(String pal) {
        if (pal.length() <= 1)
            return "";

        StringBuilder sb = new StringBuilder(pal);

        int i;
        for(i = 0; i < pal.length() / 2; i++) {
            if (sb.charAt(i) != 'a') {
                sb.setCharAt(i, 'a');
                return sb.toString();
            }
        }

        sb.setCharAt(pal.length() - 1, 'b');
        return sb.toString();
    }
}