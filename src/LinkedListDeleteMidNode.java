//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

public class LinkedListDeleteMidNode {
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        if (head == null || head.next == null)
            return null;

        while(fast != null && fast.next != null) {
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
            slow = slow.next;
        }

        if (slow == null)
            return null;
        if (slow.next == null) {
            head.next = null;
            return head;
        }

        slow.val = slow.next.val;
        slow.next = slow.next.next;
        return head;
    }

    class ListNode {
        int val;
        ListNode next;
    }
}