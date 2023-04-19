//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/


import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreeSerializeDeSerialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("# ");
            return;
        }

        sb.append(String.valueOf(root.val)).append(" ");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return buildTree(new Scanner(new java.io.ByteArrayInputStream(data.getBytes()), StandardCharsets.UTF_8));
    }

    private TreeNode buildTree(Scanner scanner) {
        if (!scanner.hasNext())
            return null;

        String next = scanner.next();
        if (next.equals("#"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(next));
        root.left = buildTree(scanner);
        root.right = buildTree(scanner);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

