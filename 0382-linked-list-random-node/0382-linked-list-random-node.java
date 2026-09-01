/**
 * LeetCode 382 - Linked List Random Node
 * 
 * Approach:
 * Use Reservoir Sampling to select one node randomly
 * without storing the entire linked list.
 */
class Solution {

    private ListNode head;

    public Solution(ListNode head) {
        this.head = head;
    }

    public int getRandom() {

        // Start with the first node as the answer
        int result = head.val;

        // Current node
        ListNode current = head.next;

        // Count of nodes processed
        int count = 2;

        while (current != null) {

            // Generate a random number from 0 to count - 1
            // Replace result with probability 1/count
            if (Math.random() < (1.0 / count)) {
                result = current.val;
            }

            current = current.next;
            count++;
        }

        return result;
    }
}