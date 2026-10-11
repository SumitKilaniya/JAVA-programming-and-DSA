class Solution:
    def sumOfSquares(self, nums):
        ans = 0
        n = len(nums)

        for i, a in enumerate(nums):
            if n % (i + 1) == 0:
                ans += a * a

        return ans