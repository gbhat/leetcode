//https://leetcode.com/problems/simplify-path/

import java.util.*;
import java.util.stream.Collectors;

public class SimplifyPath {
    public String simplifyPath(String path) {
        List<String> resultList = new LinkedList<>();
        for(String p : path.split("/")) {
            switch(p) {
                case "..":
                    if (resultList.size() > 0)
                        resultList.remove(resultList.size() - 1);
                    break;
                case ".":
                case "":
                    break;
                default:
                    resultList.add(p);
            }
        }
        return "/" + resultList.stream().collect(Collectors.joining("/"));
    }
}