//https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/

// This approach works only because problem has constraint 1 <= Node.val <= 9
public class BinaryTreePseudoPalindrome3 {
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        preorder(root, 0);
        return count;
    }

    private void preorder(TreeNode node, int path) {
        if (node == null)
            return;

        // Using XOR operation. Set the value if it was not set and clear it if it was set.
        path = path ^ (1 << node.val);
        // if it's a leaf check if the path is pseudo-palindromic
        if (node.left == null && node.right == null) {
            // If only one odd was there then path will be power of two. If all values were repeated even times then path will be 0.
            if ((path & (path - 1)) == 0) {
                ++count;
            }
        }
        preorder(node.left, path);
        preorder(node.right, path);
    }

    static class TreeNode {
        public int val;
        TreeNode left, right;
        public TreeNode(int val){this.val = val;}
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);

        int result = new BinaryTreePseudoPalindrome3().pseudoPalindromicPaths(root);
        System.out.println(result);

        root.left.left.left = new TreeNode(4);
        result = new BinaryTreePseudoPalindrome3().pseudoPalindromicPaths(root);
        System.out.println(result);

    }
}
