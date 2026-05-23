import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {

        // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        // Add all stones into heap
        for (int stone : stones) {
            pq.add(stone);
        }

        // Smash stones until one or none left
        while (pq.size() > 1) {

            int y = pq.poll(); // largest
            int x = pq.poll(); // second largest

            // If not equal, push difference
            if (y != x) {
                pq.add(y - x);
            }
        }

        // Return remaining stone or 0
        return pq.isEmpty() ? 0 : pq.poll();
    }
}