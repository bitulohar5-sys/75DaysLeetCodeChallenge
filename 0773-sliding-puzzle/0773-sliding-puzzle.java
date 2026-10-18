
import java.util.*;

class Solution {
    public int slidingPuzzle(int[][] board) {
        StringBuilder start = new StringBuilder();

        for (int[] row : board) {
            for (int num : row) {
                start.append(num);
            }
        }

        String target = "123450";

        if (start.toString().equals(target)) {
            return 0;
        }

        // Possible swaps for each position of zero
        int[][] moves = {
            {1, 3},       // position 0
            {0, 2, 4},    // position 1
            {1, 5},       // position 2
            {0, 4},       // position 3
            {1, 3, 5},    // position 4
            {2, 4}        // position 5
        };

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start.toString());
        visited.add(start.toString());

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(target)) {
                    return steps;
                }

                int zero = current.indexOf('0');

                for (int next : moves[zero]) {
                    char[] chars = current.toCharArray();

                    char temp = chars[zero];
                    chars[zero] = chars[next];
                    chars[next] = temp;

                    String newState = new String(chars);

                    if (!visited.contains(newState)) {
                        visited.add(newState);
                        queue.offer(newState);
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}
