import java.util.*;

class Solution {
    public int findShortestSubArray(int[] nums) {

        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            freq.put(num, freq.getOrDefault(num, 0) + 1);

            if (!first.containsKey(num)) {
                first.put(num, i);
            }

            last.put(num, i);
        }

        int degree = 0;
        int ans = nums.length;

        for (int num : freq.keySet()) {

            int count = freq.get(num);

            if (count > degree) {
                degree = count;
                ans = last.get(num) - first.get(num) + 1;
            }
            else if (count == degree) {
                ans = Math.min(ans,
                    last.get(num) - first.get(num) + 1);
            }
        }

        return ans;
    }
}
