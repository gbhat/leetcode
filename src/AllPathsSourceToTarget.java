//https://leetcode.com/problems/all-paths-from-source-to-target

import java.util.*;

// Using BFS
public class AllPathsSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        int n = graph.length - 1;
        for(int i = 0; i < graph[0].length; i++) {
            if (graph[0][i] == n)
                result.add(new LinkedList<>(Arrays.asList(0, graph[0][i])));
            else
                paths.add(new LinkedList<>(Arrays.asList(0, graph[0][i])));
        }

        while(!paths.isEmpty()) {
            List<List<Integer>> newpaths = new LinkedList<>();
            for(List<Integer> path : paths) {
                int node = path.get(path.size() - 1);
                for(int nodelink : graph[node]) {
                    List<Integer> newpath = new LinkedList<>(path);
                    newpath.add(nodelink);
                    if (nodelink == n) {
                        result.add(newpath);
                    } else
                        newpaths.add(newpath);
                }
            }
            paths.clear();
            paths.addAll(newpaths);
        }
        return result;
    }
}
