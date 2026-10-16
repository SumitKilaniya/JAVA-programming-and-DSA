class Solution:
    def canJump(self, nums):
        jump = 0

        for i in range(len(nums)):

            if nums[i] >= jump:
                jump = nums[i]
            else:
                jump -= 1

            if jump == 0 and i != len(nums) - 1:
                return False

        return True