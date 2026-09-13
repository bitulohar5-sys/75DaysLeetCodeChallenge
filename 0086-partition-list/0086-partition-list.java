class Solution {
    public ListNode partition(ListNode head, int x) {

        // Dummy nodes for two separate lists
        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        ListNode less = lessDummy;
        ListNode greater = greaterDummy;

        // Traverse the original list
        while (head != null) {

            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }

            head = head.next;
        }

        // Connect the two lists
        greater.next = null;
        less.next = greaterDummy.next;

        return lessDummy.next;
    }
}