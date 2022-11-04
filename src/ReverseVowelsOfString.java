//https://leetcode.com/problems/reverse-vowels-of-a-string/

import java.util.*;

public class ReverseVowelsOfString {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int low = 0, high = sb.length() - 1;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        while(low < high) {
            if (set.contains(sb.charAt(low)) && set.contains(sb.charAt(high))) {
                char temp = sb.charAt(low);
                sb.setCharAt(low, sb.charAt(high));
                sb.setCharAt(high, temp);
                low++;
                high--;
            } else if (set.contains(sb.charAt(low)))
                high--;
            else
                low++;
        }

        return sb.toString();
    }
}