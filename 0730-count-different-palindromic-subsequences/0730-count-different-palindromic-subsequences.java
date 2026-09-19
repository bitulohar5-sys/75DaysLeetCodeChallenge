import java.util.Arrays;

class Solution {
    public int countPalindromicSubsequences(String s) {

        int MOD = 1000000007;
        int n = s.length();

        long[][] dp = new long[n][n];

        // next[i][c] = first position >= i
        // where character c occurs
        int[][] next = new int[n + 1][26];

        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = n - 1; i >= 0; i--) {

            int c = s.charAt(i) - 'a';
            last[c] = i;

            for (int j = 0; j < 26; j++) {
                next[i][j] = last[j];
            }
        }

        // prev[i][c] = last position <= i
        // where character c occurs
        int[][] prev = new int[n][26];

        last = new int[26];
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {

            int c = s.charAt(i) - 'a';
            last[c] = i;

            for (int j = 0; j < 26; j++) {
                prev[i][j] = last[j];
            }
        }

        // Every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Consider substrings of increasing length
        for (int len = 2; len <= n; len++) {

            for (int i = 0; i + len <= n; i++) {

                int j = i + len - 1;

                if (s.charAt(i) != s.charAt(j)) {

                    long value =
                            dp[i + 1][j]
                            + dp[i][j - 1]
                            - dp[i + 1][j - 1];

                    dp[i][j] = (value + MOD) % MOD;

                } else {

                    int c = s.charAt(i) - 'a';

                    // First occurrence inside (i, j)
                    int left = next[i + 1][c];

                    // Last occurrence inside (i, j)
                    int right = prev[j - 1][c];

                    if (left == -1 || left > right) {

                        // No same character inside
                        dp[i][j] =
                                (2 * dp[i + 1][j - 1] + 2) % MOD;

                    } else if (left == right) {

                        // Exactly one same character inside
                        dp[i][j] =
                                (2 * dp[i + 1][j - 1] + 1) % MOD;

                    } else {

                        // Two or more same characters inside
                        long value =
                                2 * dp[i + 1][j - 1]
                                - dp[left + 1][right - 1];

                        dp[i][j] = (value + MOD) % MOD;
                    }
                }
            }
        }

        return (int) dp[0][n - 1];
    }
}