import java.util.*;

class Solution {
    Map<Integer, List<String>> memo = new HashMap<>();
    Set<String> wordSet;

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        return dfs(s, 0);
    }

    private List<String> dfs(String s, int start) {

        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> result = new ArrayList<>();

        // Entire string has been processed
        if (start == s.length()) {
            result.add("");
            return result;
        }

        for (int end = start + 1; end <= s.length(); end++) {

            String word = s.substring(start, end);

            if (wordSet.contains(word)) {

                List<String> remaining = dfs(s, end);

                for (String sentence : remaining) {

                    if (sentence.isEmpty()) {
                        result.add(word);
                    } else {
                        result.add(word + " " + sentence);
                    }
                }
            }
        }

        memo.put(start, result);

        return result;
    }
}
