//https://leetcode.com/problems/odd-even-linked-list/

public class LinkedListOddEven {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode prevOdd = null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode firstEven = head.next;

        while(odd != null && even != null) {
            prevOdd = odd;
            odd.next = even.next;
            odd = odd.next;
            if (odd != null) {
                even.next = odd.next;
                even = even.next;
            }
        }

        if (odd != null) {
            odd.next = firstEven;
        } else {
            prevOdd.next = firstEven;
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;
    }
}