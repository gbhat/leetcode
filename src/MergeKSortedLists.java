//https://leetcode.com/problems/merge-k-sorted-lists/

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null)
                pq.add(list);
        }

        ListNode result = new ListNode();
        ListNode tmp = result;
        while(!pq.isEmpty()) {
            ListNode next = pq.poll();
            if (next.next != null)
                pq.offer(next.next);
            tmp.next = next;
            tmp = tmp.next;
        }
        return result.next;
    }

    static class ListNode {
        int val;
        ListNode next;
    }
}
