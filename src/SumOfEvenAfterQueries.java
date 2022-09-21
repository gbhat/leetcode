//https://leetcode.com/problems/sum-of-even-numbers-after-queries/

public class SumOfEvenAfterQueries {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        for(int n : nums)
            sum += ((n & 1) == 0) ? n : 0;

        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int idx = queries[i][1];

            if ((nums[idx] & 1) == 0)
                sum -= nums[idx];
            nums[idx] += val;
            if ((nums[idx] & 1) == 0)
                sum += nums[idx];
            result[i] = sum;
        }

        return result;
    }
}
