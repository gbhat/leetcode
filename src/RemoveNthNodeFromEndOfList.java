//https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        for(int i = n; i > 0 && fast != null; i--)
            fast = fast.next;

        // If fast is null, we have the same count as the nodes in the list
        // we have to delete the head node
        if (fast == null)
            return head.next;

        ListNode slow = head;
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}