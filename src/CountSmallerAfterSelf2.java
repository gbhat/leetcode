//https://leetcode.com/problems/count-of-smaller-numbers-after-self/

import java.util.*;

public class CountSmallerAfterSelf2 {
    public List<Integer> countSmaller(int[] nums) {
        int[] idx = new int[nums.length];

        Integer[] result = new Integer[nums.length];
        Arrays.fill(result, 0);

        for(int i = 0; i < nums.length; i++)
            idx[i] = i;

        mergeSort(nums, 0, nums.length - 1, result, idx);
        return Arrays.asList(result);

    }

    private void mergeSort(int[] nums, int low, int high, Integer[] result, int[] idx) {
        if (low >= high)
            return;

        int mid = (low + high) / 2;
        mergeSort(nums, low, mid, result, idx);
        mergeSort(nums, mid + 1, high, result, idx);
        merge(nums, low, mid, high, result, idx);
    }

    private void merge(int[] nums, int low, int mid, int high, Integer[] result, int[] idx) {
        int[] newIdx = new int[high - low + 1];
        int[] newNums = new int[high - low + 1];
        int l = low, m = mid + 1;
        int rightCount = 0;
        int i = 0;
        while(l <= mid && m <= high) {
            if (nums[m] < nums[l]) {
                newNums[i] = nums[m];
                newIdx[i] = idx[m];
                rightCount++;
                m++;
            } else {
                newNums[i] = nums[l];
                newIdx[i] = idx[l];
                result[newIdx[i]] += rightCount;
                l++;
            }
            i++;
        }

        while(l <= mid) {
            newNums[i] = nums[l];
            newIdx[i] = idx[l];
            result[newIdx[i]] += rightCount;
            l++;
            i++;
        }

        while(m <= high) {
            newNums[i] = nums[m];
            newIdx[i] = idx[m];
            m++;
            i++;
        }

        for(i = low; i <= high; i++) {
            idx[i] = newIdx[i - low];
            nums[i] = newNums[i - low];
        }
    }
}