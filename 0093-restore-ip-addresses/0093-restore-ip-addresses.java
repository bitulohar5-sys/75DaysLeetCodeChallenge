import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int index, int parts,
                           List<String> path, List<String> result) {

        // If 4 parts are formed
        if (parts == 4) {
            if (index == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        // Try 1, 2, or 3 digits
        for (int len = 1; len <= 3; len++) {

            if (index + len > s.length()) {
                break;
            }

            String segment = s.substring(index, index + len);

            // Leading zero condition
            if (segment.length() > 1 && segment.charAt(0) == '0') {
                break;
            }

            int num = Integer.parseInt(segment);

            // IP segment must be between 0 and 255
            if (num > 255) {
                break;
            }

            path.add(segment);

            backtrack(s, index + len, parts + 1, path, result);

            // Backtracking
            path.remove(path.size() - 1);
        }
    }
}
