class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (nums[i] == 0) {
                continue;
            }

            int slow = i;
            int fast = next(nums, i);

            while (nums[slow] * nums[fast] > 0 &&
                   nums[slow] * nums[next(nums, fast)] > 0) {

                if (slow == fast) {
                    // A cycle of one element is not allowed
                    if (slow != next(nums, slow)) {
                        return true;
                    }
                    break;
                }

                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }

            // Mark this path as useless
            int j = i;

            while (nums[j] * nums[next(nums, j)] > 0) {
                nums[j] = 0;
                j = next(nums, j);
            }
        }

        return false;
    }

    private int next(int[] nums, int i) {
        int n = nums.length;

        return (i + nums[i] % n + n) % n;
    }
}