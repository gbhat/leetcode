//https://leetcode.com/problems/decode-ways/

public class DecodeWays4 {
    public int numDecodings(String s) {
        int dp1 = 1, dp2 = 0, n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            int dp = s.charAt(i) == '0' ? 0 : dp1;
            if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))
                dp += dp2;
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }
}