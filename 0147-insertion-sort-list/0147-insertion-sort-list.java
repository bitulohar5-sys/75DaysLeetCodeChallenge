/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr = head;

        while (curr != null) {
            ListNode prev = dummy;

            // Find the correct position to insert curr
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Save the next node
            ListNode nextNode = curr.next;

            // Insert curr between prev and prev.next
            curr.next = prev.next;
            prev.next = curr;

            // Move to the next node
            curr = nextNode;
        }

        return dummy.next;
    }
}