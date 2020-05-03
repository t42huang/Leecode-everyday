class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) ==0:
            return 0
        # memo[]  表示以num[end]为结尾的 LIS
        memo = [1]*(len(nums))
        for end in range(1, len(nums)):
            for j in range(0,end):
                if nums[j] < nums[end]:
                    if memo[end] <= memo[j]:
                        memo[end] = memo[j] + 1
        return max(memo)
        
