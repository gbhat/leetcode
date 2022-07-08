//https://leetcode.com/problems/interleaving-string/

// Recursive solution. Does not work for large inputs. Check InterleavingString2.java, InterleavingString3.java
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int i = 0, j = 0, k = 0;

        if (s1.length() + s2.length() != s3.length())
            return false;

        return check(s1, s2, s3, i, j, k);
    }

    private boolean check(String s1, String s2, String s3, int i, int j, int k) {
        if (k == s3.length() && i == s1.length() && j == s2.length())
            return true;

        if (k >= s3.length())
            return false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k) && j < s2.length() && s2.charAt(j) == s3.charAt(k))
            return check(s1, s2, s3, i + 1, j, k + 1) || check(s1, s2, s3, i, j + 1, k + 1);
        else if (i < s1.length() && s1.charAt(i) == s3.charAt(k))
            return check(s1, s2, s3, i + 1, j, k + 1);
        else if (j < s2.length() && s2.charAt(j) == s3.charAt(k))
            return check(s1, s2, s3, i, j + 1, k + 1);
        else
            return false;
    }
}