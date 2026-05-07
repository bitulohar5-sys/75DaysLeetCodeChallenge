class Solution:
    def totalFruit(self, fruits):
        basket = {}
        left = 0
        max_len = 0

        for right in range(len(fruits)):

            # add current fruit
            basket[fruits[right]] = basket.get(fruits[right], 0) + 1

            # shrink window if more than 2 fruit types
            while len(basket) > 2:

                basket[fruits[left]] -= 1

                # remove fruit if count becomes 0
                if basket[fruits[left]] == 0:
                    del basket[fruits[left]]

                left += 1

            # update answer
            max_len = max(max_len, right - left + 1)

        return max_len