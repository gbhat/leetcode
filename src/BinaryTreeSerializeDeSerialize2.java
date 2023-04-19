//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/


import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreeSerializeDeSerialize2 {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new LinkedList<>();
        preorder(root, list);
        return String.join("X", list);
    }

    private void preorder(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("");
            return;
        }

        list.add(String.valueOf(root.val));
        preorder(root.left, list);
        preorder(root.right, list);
    }

    int idx = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // System.out.println(data);
        return buildTree(data.split("X"));
    }

    private TreeNode buildTree(String[] data) {
        if (idx >= data.length)
            return null;

        if (data[idx].equals("")) {
            idx++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(data[idx++]));
        root.left = buildTree(data);
        root.right = buildTree(data);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

