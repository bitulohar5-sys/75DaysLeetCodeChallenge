class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Edge case
        if (head == null || left == right) return head;

        // Dummy node to handle edge cases easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 1: Reach node before 'left'
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 2: Reverse the sublist
        ListNode curr = prev.next;
        ListNode next = null;

        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }
}