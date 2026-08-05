/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeHelper(lists, 0, lists.length - 1);
    }

    public ListNode mergeHelper(ListNode[] lists, int start, int end) {

        if (start == end) {
            return lists[start];
        }

        if (start + 1 == end) {
            return merge2lists(lists[start], lists[end]);
        }

        int mid = start + (end - start) / 2;

        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);

        return merge2lists(left, right);
    }

    public ListNode merge2lists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                curr.next = l1;       // attach current l1 node
                l1 = l1.next;
            } else {
                curr.next = l2;       // attach current l2 node
                l2 = l2.next;
            }

            curr = curr.next;
        }

        while (l1 != null) {
            curr.next = l1;           // NOT l1.next
            l1 = l1.next;
            curr = curr.next;
        }

        while (l2 != null) {
            curr.next = l2;           // NOT l2.next
            l2 = l2.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}