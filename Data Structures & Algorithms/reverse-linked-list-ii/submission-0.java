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
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode sublistHead = prev.next;
        ListNode sublistTail = sublistHead;
        for (int i = 0; i < right - left; i++) {
            sublistTail = sublistTail.next;
        }

        ListNode nextNode = sublistTail.next;
        sublistTail.next = null;
        prev.next = reverseList(sublistHead);
        sublistHead.next = nextNode;

        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}