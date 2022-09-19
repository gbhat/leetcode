//https://leetcode.com/problems/find-duplicate-file-in-system/

import java.util.*;

public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String path : paths) {
            String[] split = path.split(" ");
            for(int i = 1 ; i < split.length; i++) {
                String fullName = split[0] + "/" + split[i].substring(0, split[i].indexOf('('));
                String content = split[i].substring(split[i].indexOf('(') + 1, split[i].lastIndexOf(')'));
                map.putIfAbsent(content, new LinkedList<String>());
                map.get(content).add(fullName);
            }
        }

        List<List<String>> result = new LinkedList<>();
        for(List<String> value : map.values()) {
            if (value.size() > 1)
                result.add(value);
        }
        return result;
    }
}
