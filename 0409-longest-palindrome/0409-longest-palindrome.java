class Solution {
    public int longestPalindrome(String s) {

        int[] freq = new int[128];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }

        int length = 0;
        boolean oddFound = false;

        // Calculate palindrome length
        for (int count : freq) {

            // Use the even portion of each frequency
            length += (count / 2) * 2;

            // Check if any character has odd frequency
            if (count % 2 == 1) {
                oddFound = true;
            }
        }

        // One odd character can be placed in the center
        if (oddFound) {
            length++;
        }

        return length;
    }
}
