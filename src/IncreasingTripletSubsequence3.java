//https://leetcode.com/problems/increasing-triplet-subsequence/

public class IncreasingTripletSubsequence3 {
    public boolean increasingTriplet(int[] nums) {
        int low1 = Integer.MAX_VALUE, low2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= low2 && num <= low1)
                low1 = num;
            else if (num <= low2)
                low2 = num;
            else return true;
        }
        return false;
    }
}