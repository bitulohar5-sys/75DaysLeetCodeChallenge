
class Solution {
    public int strongPasswordChecker(String password) {
        int n = password.length();

        boolean lower = false;
        boolean upper = false;
        boolean digit = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) lower = true;
            if (Character.isUpperCase(c)) upper = true;
            if (Character.isDigit(c)) digit = true;
        }

        int missing = (lower ? 0 : 1)
                    + (upper ? 0 : 1)
                    + (digit ? 0 : 1);

        int replace = 0;
        int one = 0;
        int two = 0;

        for (int i = 0; i < n;) {
            int j = i;

            while (j < n && password.charAt(j) == password.charAt(i)) {
                j++;
            }

            int len = j - i;

            if (len >= 3) {
                replace += len / 3;

                if (len % 3 == 0) {
                    one++;
                } else if (len % 3 == 1) {
                    two++;
                }
            }

            i = j;
        }

        if (n < 6) {
            return Math.max(6 - n, missing);
        }

        if (n <= 20) {
            return Math.max(missing, replace);
        }

        int delete = n - 20;

        // First, delete characters from runs where
        // one deletion can reduce the replacement count.
        int use = Math.min(delete, one);
        replace -= use;
        delete -= use;

        // Next, use two deletions to reduce one replacement.
        use = Math.min(delete, two * 2);
        replace -= use / 2;
        delete -= use;

        // Remaining deletions reduce one replacement
        // for every three deletions.
        replace -= delete / 3;

        return (n - 20) + Math.max(missing, replace);
    }
}
