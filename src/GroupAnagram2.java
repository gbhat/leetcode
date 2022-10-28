//https://leetcode.com/problems/group-anagrams/

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupAnagram2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, String> sortedMap = new HashMap<>();
        sortStrs(strs, sortedMap);

        HashMap<String, List<String>> resultMap = new HashMap<>();
        for(String str : strs) {
            String sorted = sortedMap.get(str);
            resultMap.putIfAbsent(sorted, new LinkedList<String>());
            resultMap.get(sorted).add(str);
        }

        return new LinkedList<>(resultMap.values());
    }

    private void sortStrs(String[] strs, HashMap<String, String> sortedMap) {
        for(String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            sortedMap.put(str, String.valueOf(arr));
        }
    }
}
