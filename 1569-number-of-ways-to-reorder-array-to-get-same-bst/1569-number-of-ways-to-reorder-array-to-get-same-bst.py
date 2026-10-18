class Solution(object):
    def numOfWays(self, nums):
        MOD = int(1e9) + 7
        
        def countPermutations(nums):
            n = len(nums)
            
            if n <= 1:
                return 1
            
            left = [num for num in nums if num < nums[0]]
            right = [num for num in nums if num > nums[0]]
            
            # Recursively count the permutations of the left and right subtrees
            count_left = countPermutations(left)
            count_right = countPermutations(right)
            
            # Calculate the total number of ways
            total = (combinations(n - 1, len(left)) * count_left * count_right) % MOD
            
            return total
        
        # Helper function to calculate the number of combinations
        def combinations(n, k):
            numerator = 1
            denominator = 1
            
            for i in range(k):
                numerator *= (n - i)
                denominator *= (i + 1)
            
            return numerator // denominator
        
        return (countPermutations(nums) - 1) % MOD


        """
        :type nums: List[int]
        :rtype: int
        """