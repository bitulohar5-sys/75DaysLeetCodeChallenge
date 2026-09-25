import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        int leftRemove = 0;
        int rightRemove = 0;

        // Find minimum number of '(' and ')' to remove
        for (char c : s.toCharArray()) {

            if (c == '(') {
                leftRemove++;
            } 
            else if (c == ')') {
                if (leftRemove > 0) {
                    leftRemove--;
                } 
                else {
                    rightRemove++;
                }
            }
        }

        backtrack(s, 0, leftRemove, rightRemove, result);

        return result;
    }

    private void backtrack(
        String s,
        int start,
        int leftRemove,
        int rightRemove,
        List<String> result
    ) {

        // No more parentheses need to be removed
        if (leftRemove == 0 && rightRemove == 0) {

            if (isValid(s)) {
                result.add(s);
            }

            return;
        }

        for (int i = start; i < s.length(); i++) {

            // Skip duplicate parentheses
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            char c = s.charAt(i);

            // Remove '('
            if (c == '(' && leftRemove > 0) {

                String next =
                    s.substring(0, i) + s.substring(i + 1);

                backtrack(
                    next,
                    i,
                    leftRemove - 1,
                    rightRemove,
                    result
                );
            }

            // Remove ')'
            if (c == ')' && rightRemove > 0) {

                String next =
                    s.substring(0, i) + s.substring(i + 1);

                backtrack(
                    next,
                    i,
                    leftRemove,
                    rightRemove - 1,
                    result
                );
            }
        }
    }

    // Check whether parentheses are valid
    private boolean isValid(String s) {

        int balance = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                balance++;
            } 
            else if (c == ')') {
                balance--;

                // More ')' than '('
                if (balance < 0) {
                    return false;
                }
            }
        }

        return balance == 0;
    }
}