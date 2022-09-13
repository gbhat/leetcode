//https://leetcode.com/problems/combination-sum/

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        findSum(candidates, 0, 0, target, list, result);
        return result;
    }

    private void findSum(int[] candidates, int idx, int sum, int target, List<Integer> list, List<List<Integer>> result) {
        if (idx >= candidates.length || sum > target)
            return;

        if (sum == target) {
            result.add(new LinkedList<>(list));
            return;
        }

        list.add(candidates[idx]);
        sum += candidates[idx];
        findSum(candidates, idx, sum, target, list, result);

        int n = list.remove(list.size() - 1);
        sum -= n;
        findSum(candidates, idx + 1, sum, target, list, result);
    }
}