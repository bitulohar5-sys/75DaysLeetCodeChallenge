class Solution {
    public int numDupDigitsAtMostN(int n) {

        String s = String.valueOf(n);
        int len = s.length();

        // Count numbers with fewer digits
        int unique = 0;

        for (int i = 1; i < len; i++) {
            unique += 9 * perm(9, i - 1);
        }

        // Count numbers with same number of digits
        boolean[] used = new boolean[10];

        for (int i = 0; i < len; i++) {

            int digit = s.charAt(i) - '0';

            for (int d = (i == 0 ? 1 : 0); d < digit; d++) {

                if (!used[d]) {
                    unique += perm(9 - i, len - i - 1);
                }
            }

            if (used[digit]) {
                break;
            }

            used[digit] = true;

            if (i == len - 1) {
                unique++;
            }
        }

        return n - unique;
    }

    private int perm(int m, int k) {
        int result = 1;

        for (int i = 0; i < k; i++) {
            result *= (m - i);
        }

        return result;
    }
}
