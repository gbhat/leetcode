//https://leetcode.com/problems/contains-duplicate-ii/

import java.util.*;

public class ContainsDuplicates_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new LinkedHashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if (set.size() > k)
                set.remove(set.iterator().next());
        }

        return false;
    }
}
