import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {

        // Store the last occurrence of each character
        int[] last = new int[26];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        // To check whether a character is already in the stack
        boolean[] visited = new boolean[26];

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            int index = ch - 'a';

            // If character is already present, skip it
            if (visited[index]) {
                continue;
            }

            // Remove bigger characters if they appear again later
            while (!stack.isEmpty()
                    && stack.peek() > ch
                    && last[stack.peek() - 'a'] > i) {

                char removed = stack.pop();
                visited[removed - 'a'] = false;
            }

            // Add current character
            stack.push(ch);
            visited[index] = true;
        }

        // Build the answer
        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}