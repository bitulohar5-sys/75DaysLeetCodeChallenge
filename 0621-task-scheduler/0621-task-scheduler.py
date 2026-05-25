class Solution:
    def leastInterval(self, tasks, n):
        
        freq = [0] * 26

        # Count frequency of each task
        for task in tasks:
            freq[ord(task) - ord('A')] += 1

        # Maximum frequency
        maxFreq = max(freq)

        # Count tasks having maximum frequency
        countMax = freq.count(maxFreq)

        # Apply formula
        intervals = (maxFreq - 1) * (n + 1) + countMax

        return max(len(tasks), intervals)