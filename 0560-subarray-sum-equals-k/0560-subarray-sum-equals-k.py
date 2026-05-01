class Solution:
    def subarraySum(self, nums, k):
        prefix_sum = 0
        count = 0
        mp = {0: 1}

        get = mp.get  # local reference (faster)

        for num in nums:
            prefix_sum += num
            count += get(prefix_sum - k, 0)
            mp[prefix_sum] = get(prefix_sum, 0) + 1

        return count