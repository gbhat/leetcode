//https://leetcode.com/problems/reverse-words-in-a-string-iii/

public class ReverseWordsInString_III {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) == ' ') {
                for(int j = i - 1; j >= 0 && s.charAt(j) != ' '; j--) {
                    sb.append(s.charAt(j));
                }
                if (i != s.length())
                    sb.append(' ');
            }
        }
        return sb.toString();
    }
}