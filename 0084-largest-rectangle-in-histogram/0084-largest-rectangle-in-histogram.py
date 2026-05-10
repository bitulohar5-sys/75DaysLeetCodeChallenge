class Solution:
    def largestRectangleArea(self, heights):
        stack = []
        max_area = 0
        n = len(heights)

        for i in range(n + 1):

            # Current height
            curr_height = 0 if i == n else heights[i]

            # Calculate area while current bar is smaller
            while stack and curr_height < heights[stack[-1]]:

                height = heights[stack.pop()]

                # Width calculation
                if not stack:
                    width = i
                else:
                    width = i - stack[-1] - 1

                max_area = max(max_area, height * width)

            stack.append(i)

        return max_area