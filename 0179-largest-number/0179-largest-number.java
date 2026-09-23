import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {

        // Convert integers to strings
        String[] arr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Custom sorting
        Arrays.sort(arr, (a, b) -> {
            return (b + a).compareTo(a + b);
        });

        // If the largest element is "0",
        // then all elements are zero
        if (arr[0].equals("0")) {
            return "0";
        }

        // Build answer
        StringBuilder result = new StringBuilder();

        for (String s : arr) {
            result.append(s);
        }

        return result.toString();
    }
}