//https://leetcode.com/problems/group-anagrams/

import java.util.*;

// Gives TLE
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> strList = new LinkedList<>(Arrays.asList(strs));
        List<HashMap<Character, Integer>> freq = new LinkedList<>();
        for(String str : strs) {
            HashMap<Character, Integer> map = new HashMap<>();
            for(char ch : str.toCharArray())
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            freq.add(map);
        }


        List<List<String>> result = new LinkedList<>();
        while(freq.size() > 0) {
            HashMap<Character, Integer> map = freq.remove(0);
            List<String> res = new LinkedList<>();
            res.add(strList.remove(0));
            for(int j = 0; j < freq.size();) {
                if (map.equals(freq.get(j))) {
                    freq.remove(j);             // Since we remove the entry from list, dont increment j
                    res.add(strList.remove(j));
                } else
                    j++;    // Increment j only if we dont have a matching entry
            }
            result.add(res);
        }
        return result;
    }
}
