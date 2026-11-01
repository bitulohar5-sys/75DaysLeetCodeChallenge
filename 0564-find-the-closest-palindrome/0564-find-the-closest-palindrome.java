class Solution {
    public String nearestPalindromic(String n) {

        int len = n.length();

        Set<Long> candidates = new HashSet<>();

        // Edge cases
        candidates.add((long) Math.pow(10, len - 1) - 1);
        candidates.add((long) Math.pow(10, len) + 1);

        // Get the first half
        long prefix = Long.parseLong(
            n.substring(0, (len + 1) / 2)
        );

        // Try prefix - 1, prefix, prefix + 1
        for (long i = prefix - 1; i <= prefix + 1; i++) {

            String left = String.valueOf(i);

            String palindrome;

            if (len % 2 == 0) {
                palindrome = left +
                    new StringBuilder(left).reverse();
            } else {
                palindrome = left +
                    new StringBuilder(left.substring(0, left.length() - 1))
                    .reverse();
            }

            candidates.add(Long.parseLong(palindrome));
        }

        long original = Long.parseLong(n);
        long answer = -1;

        for (long candidate : candidates) {

            if (candidate == original) {
                continue;
            }

            if (answer == -1 ||
                Math.abs(candidate - original) <
                Math.abs(answer - original) ||
                (Math.abs(candidate - original) ==
                 Math.abs(answer - original) &&
                 candidate < answer)) {

                answer = candidate;
            }
        }

        return String.valueOf(answer);
    }
}