//https://leetcode.com/problems/binary-tree-cameras/

public class BinaryTreeCameras {
    private int res;
    public int minCameraCover(TreeNode root) {
        if(dfs(root) == 0) res++;
        return res;
    }
    private int dfs(TreeNode node){
        if(node == null) return 1;
        int left = dfs(node.left);
        int right = dfs(node.right);
        if(left == 0 || right == 0){
            res++;
            return 2;
        }
        if(left == 2 || right == 2)
            return 1;
        return 0;
    }

    // Test code below

    static class TreeNode {
        public int data;
        public TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
    public static void main(String[] args) {
/*
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(4);
        root.left.right.left.right = new TreeNode(5);
        root.left.right.left.right.left = new TreeNode(6);
*/
/*
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.left.right = new TreeNode(4);
        root.right.left.right.left = new TreeNode(5);
        root.right.left.right.left.right = new TreeNode(6);
        root.right.left.right.left.right.left = new TreeNode(7);
*/

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int ret = new BinaryTreeCameras().minCameraCover(root);
        System.out.println(ret);
    }
}