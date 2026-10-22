import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (indexDiff <= 0 || valueDiff < 0) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long current = nums[i];

            // Find the smallest number >= current
            Long ceiling = set.ceiling(current);

            if (ceiling != null && ceiling - current <= valueDiff) {
                return true;
            }

            // Find the largest number <= current
            Long floor = set.floor(current);

            if (floor != null && current - floor <= valueDiff) {
                return true;
            }

            set.add(current);

            // Maintain at most indexDiff previous elements
            if (set.size() > indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }
}
