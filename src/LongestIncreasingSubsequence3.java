//https://leetcode.com/problems/longest-increasing-subsequence/

public class LongestIncreasingSubsequence3 {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

    public static void main(String[] args){
        int[] nums = {0, 1, 0, 3, 2, 3};
        System.out.println(new LongestIncreasingSubsequence3().lengthOfLIS(nums));
    }
}