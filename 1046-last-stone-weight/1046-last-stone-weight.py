import heapq

class Solution:
    def lastStoneWeight(self, stones):
        # Convert into max heap by using negative values
        stones = [-stone for stone in stones]
        heapq.heapify(stones)

        # Continue until one or no stone remains
        while len(stones) > 1:
            y = -heapq.heappop(stones)  # largest
            x = -heapq.heappop(stones)  # second largest

            # If stones are not equal
            if y != x:
                heapq.heappush(stones, -(y - x))

        # Return remaining stone or 0
        return -stones[0] if stones else 0