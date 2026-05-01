class Solution:
    def subarraySum(self, nums, k):
        prefix_sum = 0
        count = 0
        mp = {0: 1}   # prefix sum frequency

        for num in nums:
            prefix_sum += num
            
            if (prefix_sum - k) in mp:
                count += mp[prefix_sum - k]
            
            mp[prefix_sum] = mp.get(prefix_sum, 0) + 1

        return count