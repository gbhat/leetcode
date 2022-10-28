//https://leetcode.com/problems/group-anagrams/

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupAnagram3 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> resultMap = new HashMap<>();
        for(String str : strs) {
            int[] countArr = new int[26];
            for(char ch : str.toCharArray())
                countArr[ch - 'a']++;
            String countStr = Arrays.toString(countArr);
            resultMap.putIfAbsent(countStr, new LinkedList<String>());
            resultMap.get(countStr).add(str);
        }

        return new LinkedList<>(resultMap.values());
    }
}
