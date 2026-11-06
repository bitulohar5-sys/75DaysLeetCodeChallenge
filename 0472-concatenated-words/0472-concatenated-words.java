import java.util.*;

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        Set<String> set = new HashSet<>();

        for (String word : words) {
            set.add(word);
        }

        List<String> result = new ArrayList<>();

        for (String word : words) {

            set.remove(word);

            int n = word.length();

            boolean[] dp = new boolean[n + 1];

            dp[0] = true;

            for (int i = 1; i <= n; i++) {

                for (int j = 0; j < i; j++) {

                    if (dp[j] && set.contains(word.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            if (dp[n]) {
                result.add(word);
            }

            set.add(word);
        }

        return result;
    }
}
