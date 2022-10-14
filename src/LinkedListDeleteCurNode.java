//https://leetcode.com/problems/delete-node-in-a-linked-list/

public class LinkedListDeleteCurNode {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null)
            return;

        node.val = node.next.val;
        node.next = node.next.next;
    }

    class ListNode {
        int val;
        ListNode next;
    }
}