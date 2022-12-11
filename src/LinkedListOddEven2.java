//https://leetcode.com/problems/odd-even-linked-list/

public class LinkedListOddEven2 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
    }
}