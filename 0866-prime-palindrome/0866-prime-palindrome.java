class Solution {
    public int primePalindrome(int n) {

        // Special case
        if (n >= 8 && n <= 11) {
            return 11;
        }

        for (int i = 1; i < 100000; i++) {

            String s = String.valueOf(i);

            // Generate odd-length palindrome
            StringBuilder sb = new StringBuilder(s);
            sb.setLength(sb.length() - 1);

            String palindrome = s + sb.reverse().toString();

            int num = Integer.parseInt(palindrome);

            if (num >= n && isPrime(num)) {
                return num;
            }
        }

        return -1;
    }

    // Check whether number is prime
    private boolean isPrime(int num) {

        if (num < 2) {
            return false;
        }

        if (num % 2 == 0) {
            return num == 2;
        }

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
