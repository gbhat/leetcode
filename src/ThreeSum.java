//https://leetcode.com/problems/3sum/

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new LinkedList<>();
        int i = 0;
        while (i < nums.length) {
            while(i > 0 && i < nums.length && nums[i] == nums[i - 1])
                i++;
            int j = i + 1, k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while(j < nums.length && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else if (sum < 0)
                    j++;
                else
                    k--;
            }
            i++;
        }

        return result;
    }
}