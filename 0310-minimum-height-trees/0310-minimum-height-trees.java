import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

      
        if (n == 1) {
            return new ArrayList<>(Arrays.asList(0));
        }

        // Adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Degree of each node
        int[] degree = new int[n];

        // Build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        // Put all leaves into queue
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        int remainingNodes = n;

        // Remove layers of leaves
        while (remainingNodes > 2) {

            int size = queue.size();

            remainingNodes -= size;

            for (int i = 0; i < size; i++) {

                int leaf = queue.poll();

                for (int neighbor : graph.get(leaf)) {

                    degree[neighbor]--;

                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        // Remaining nodes are the centers
        return new ArrayList<>(queue);
    }
}