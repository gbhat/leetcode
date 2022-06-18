//https://leetcode.com/problems/product-of-array-except-self/

import java.util.Arrays;

public class ProdArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, 1);
        int left = 1, right = 1;
        for (int i = 0; i < n; i++) {
            answer[i] *= left;
            left *= nums[i];
            answer[n - 1 - i] *= right;
            right *= nums[n - 1 - i];
        }
        return answer;
    }
}
