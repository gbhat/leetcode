//https://leetcode.com/problems/maximum-69-number/


// Converts to String. Probably not a great idea.
public class Maximum69Number {
    public int maximum69Number (int num) {
        return Integer.parseInt(String.valueOf(num).replaceFirst("6", "9"));
    }
}