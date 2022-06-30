//https://leetcode.com/problems/count-of-smaller-numbers-after-self/

import java.util.Arrays;
import java.util.List;

// Brute force solution. This gives timeout exception. Check CountSmallerAfterSelf2.java
public class CountSmallerAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] result = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i])
                    cnt++;
            }
            result[i] = cnt;
        }
        return Arrays.asList(result);
    }
}