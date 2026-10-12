
import java.util.*;

class Solution {
    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = new HashMap<>();

        // Build the graph
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, value);
            graph.get(b).put(a, 1.0 / value);
        }

        double[] answer = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            answer[i] = dfs(start, end, graph, new HashSet<>());
        }

        return answer;
    }

    private double dfs(
            String start,
            String end,
            Map<String, Map<String, Double>> graph,
            Set<String> visited) {

        // Unknown variable
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return -1.0;
        }

        // Same variable
        if (start.equals(end)) {
            return 1.0;
        }

        visited.add(start);

        for (Map.Entry<String, Double> edge :
                graph.get(start).entrySet()) {

            String next = edge.getKey();
            double weight = edge.getValue();

            if (!visited.contains(next)) {
                double result = dfs(next, end, graph, visited);

                if (result != -1.0) {
                    return weight * result;
                }
            }
        }

        return -1.0;
    }
}
