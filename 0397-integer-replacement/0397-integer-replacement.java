class Solution {
    public int integerReplacement(int n) {
        long num = n;  // Use long to avoid overflow when n = Integer.MAX_VALUE
        int steps = 0;

        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                // Choose the option that creates more factors of 2
                if (num == 3 || num % 4 == 1) {
                    num--;
                } else {
                    num++;
                }
            }

            steps++;
        }

        return steps;
    }
}