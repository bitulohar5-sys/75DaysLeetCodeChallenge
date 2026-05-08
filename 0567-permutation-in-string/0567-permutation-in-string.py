class Solution:
    def checkInclusion(self, s1, s2):

        if len(s1) > len(s2):
            return False

        s1_count = [0] * 26
        window_count = [0] * 26

        # Count characters of s1
        for ch in s1:
            s1_count[ord(ch) - ord('a')] += 1

        left = 0

        # Sliding window
        for right in range(len(s2)):

            window_count[ord(s2[right]) - ord('a')] += 1

            # Maintain window size
            if right - left + 1 > len(s1):
                window_count[ord(s2[left]) - ord('a')] -= 1
                left += 1

            # Compare frequency arrays
            if s1_count == window_count:
                return True

        return False