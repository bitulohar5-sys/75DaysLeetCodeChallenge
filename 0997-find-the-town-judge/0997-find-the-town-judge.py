class Solution:
    def findJudge(self, n, trust):

        indegree = [0] * (n + 1)
        outdegree = [0] * (n + 1)

        # Count trust relationships
        for a, b in trust:
            outdegree[a] += 1
            indegree[b] += 1

        # Find the judge
        for i in range(1, n + 1):
            if indegree[i] == n - 1 and outdegree[i] == 0:
                return i

        return -1