class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {

            // add current fruit
            map.put(fruits[right],
                    map.getOrDefault(fruits[right], 0) + 1);

            // if more than 2 fruit types
            while (map.size() > 2) {

                map.put(fruits[left], map.get(fruits[left]) - 1);

                // remove if count becomes 0
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                left++;
            }

            // update answer
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}