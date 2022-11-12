//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

public class RemoveAdjacentDupString2 {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        int end = 0;
        for(int i = 0; i < sb.length() ; i++) {
            if (end > 0 && sb.charAt(i) == sb.charAt(end - 1))
                end--;
            else
                sb.setCharAt(end++, sb.charAt(i));
        }
        return sb.substring(0, end).toString();
    }
}