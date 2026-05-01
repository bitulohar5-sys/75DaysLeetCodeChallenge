from collections import defaultdict

class Solution:
    def subarraySum(self, nums, k):
        prefix_sum = 0
        count = 0
        mp = defaultdict(int)
        mp[0] = 1

        for num in nums:
            prefix_sum += num
            count += mp[prefix_sum - k]
            mp[prefix_sum] += 1

        return count