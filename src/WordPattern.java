//https://leetcode.com/problems/word-pattern

import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if (pattern.length() != split.length)
            return false;
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
            Character key = pattern.charAt(i);
            if (map1.containsKey(key)) {
                if (!split[i].equals(map1.get(key)))
                    return false;
            } else if (map2.containsKey(split[i])) {
                if (map2.get(split[i]) != key)
                    return false;
            } else {
                map1.put(key, split[i]);
                map2.put(split[i], key);
            }
        }
        return true;
    }
}