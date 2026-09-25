class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;

        // Check all 32 bits
        for (int i = 0; i < 32; i++) {
            int count = 0;

            // Count how many numbers have the ith bit set
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    count++;
                }
            }

            // Remove bits contributed by numbers appearing 3 times
            if (count % 3 != 0) {
                ans |= (1 << i);
            }
        }

        return ans;
    }
}