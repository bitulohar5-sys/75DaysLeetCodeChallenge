class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] freq = new int[26];

        // Count the frequency of each character
        for (char ch : magazine.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Check whether ransomNote can be constructed
        for (char ch : ransomNote.toCharArray()) {
            freq[ch - 'a']--;

            if (freq[ch - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
