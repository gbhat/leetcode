//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree

public class SortedListToBST {
    ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
        cur = head;
        int count = 0;
        for(ListNode tmp = head; tmp != null; tmp = tmp.next)
            count++;
        return buildTree(head, 0, count - 1);
    }

    private TreeNode buildTree(ListNode head, int low, int high) {
        if (low > high)
            return null;
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(-1);        //Initial value, will be overwritten
        root.left = buildTree(head, low, mid - 1);
        root.val = cur.val;
        cur = cur.next;
        root.right = buildTree(head, mid + 1, high);
        return root;
    }


    public class ListNode {
        int val;
        ListNode next;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
