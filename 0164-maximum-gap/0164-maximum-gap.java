class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;

        if (n < 2) {
            return 0;
        }

        int min = nums[0];
        int max = nums[0];

        // Find minimum and maximum
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) {
            return 0;
        }

        // Calculate bucket size
        int bucketSize = Math.max(1, (max - min + n - 2) / (n - 1));

        // Number of buckets
        int bucketCount = (max - min) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];

        // Mark empty buckets
        boolean[] used = new boolean[bucketCount];

        // Put numbers into buckets
        for (int num : nums) {
            int index = (num - min) / bucketSize;

            if (!used[index]) {
                bucketMin[index] = num;
                bucketMax[index] = num;
                used[index] = true;
            } else {
                bucketMin[index] = Math.min(bucketMin[index], num);
                bucketMax[index] = Math.max(bucketMax[index], num);
            }
        }

        // Find maximum gap between buckets
        int answer = 0;
        int previousMax = min;

        for (int i = 0; i < bucketCount; i++) {
            if (!used[i]) {
                continue;
            }

            answer = Math.max(answer, bucketMin[i] - previousMax);
            previousMax = bucketMax[i];
        }

        return answer;
    }
}