class Solution {
    int[] nums;
    int[] temp;

    public int reversePairs(int[] nums) {
        this.nums = nums;
        this.temp = new int[nums.length];

        return mergeSort(0, nums.length - 1);
    }

    private int mergeSort(int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        int count = 0;

        
        count += mergeSort(left, mid);
        count += mergeSort(mid + 1, right);

    
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {

            while (j <= right && (long) nums[i] > 2L * nums[j]) {
                j++;
            }

            count += j - (mid + 1);
        }

    
        int i = left;
        j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        for (i = left; i <= right; i++) {
            nums[i] = temp[i];
        }

        return count;
    }
}