//https://leetcode.com/problems/find-duplicate-subtrees/

import java.util.*;

public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, List<TreeNode>> map = new HashMap<>();
        buildMap(root, map);

        List<TreeNode> result = new LinkedList<>();
        for (Map.Entry<String, List<TreeNode>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1)
                result.add(entry.getValue().get(0));
        }

        return result;
    }

    private String buildMap(TreeNode root, HashMap<String, List<TreeNode>> map) {
        if (root == null)
            return "null";

        String str = root.val + "|";
        str += buildMap(root.left, map) + "|";
        str += buildMap(root.right, map) + "|";

        map.putIfAbsent(str, new LinkedList<>());
        map.get(str).add(root);
        return str;
    }

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
