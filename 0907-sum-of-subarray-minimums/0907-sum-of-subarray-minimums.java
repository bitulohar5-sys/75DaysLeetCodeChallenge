class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long MOD = 1_000_000_007L;
        long result = 0;

        int[] stack = new int[n];
        int top = -1;

        int[] left = new int[n];
        int[] right = new int[n];

        // Previous Smaller Element
        for (int i = 0; i < n; i++) {
            while (top >= 0 && arr[stack[top]] >= arr[i]) {
                top--;
            }

            left[i] = (top >= 0) ? i - stack[top] : i + 1;
            stack[++top] = i;
        }

        top = -1;

        // Next Smaller Element or Equal Element
        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0 && arr[stack[top]] > arr[i]) {
                top--;
            }

            right[i] = (top >= 0) ? stack[top] - i : n - i;
            stack[++top] = i;
        }

        // Calculate each element's contribution
        for (int i = 0; i < n; i++) {
            long contribution =
                (long) arr[i] * left[i] * right[i];

            result = (result + contribution) % MOD;
        }

        return (int) result;
    }
}
