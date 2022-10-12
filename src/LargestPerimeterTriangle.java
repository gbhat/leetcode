//https://leetcode.com/problems/largest-perimeter-triangle/

import java.util.Arrays;

/*
    To construct any triangle, sum of two smaller sides should be greater than the third side
 */
public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {
        if (nums.length < 3)
            return 0;

        Arrays.sort(nums);
        for(int i = nums.length - 1; i > 1; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2])
                return nums[i] + nums[i - 1] + nums[i - 2];
        }
        return 0;
    }
}
