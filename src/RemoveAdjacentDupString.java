//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

// This gives TLE
public class RemoveAdjacentDupString {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        while(sb.length() > 0) {
            int idx = findDup(sb);
            if (idx == -1)
                break;
            sb.deleteCharAt(idx);
            sb.deleteCharAt(idx);
        }

        return sb.toString();
    }

    private int findDup(StringBuilder sb) {
        for(int i = 0; i < sb.length() - 1; i++)
            if (sb.charAt(i) == sb.charAt(i + 1))
                return i;
        return -1;
    }
}