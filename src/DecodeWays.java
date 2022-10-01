//https://leetcode.com/problems/decode-ways/

// Recursive solution. Gives TLE
public class DecodeWays {
    public int numDecodings(String s) {
        return numDec(s);
    }

    private int numDec(String s) {
        if (s.length() == 0)
            return 1;

        int ret = 0;
        for(int i = 1; i <= 9; i++) {
            if (s.startsWith(String.valueOf(i))) {
                ret = numDec(s.substring(1));
            }
        }

        for(int i = 10; i <= 26; i++) {
            if (s.startsWith(String.valueOf(i))) {
                ret += numDec(s.substring(2));
            }
        }

        return ret;
    }
}