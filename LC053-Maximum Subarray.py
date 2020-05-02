class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        start, end, res = 0, 1, nums[0]  

        while start < len(nums):   
            sums = nums[start]                  
            for i in range(start+1,len(nums)):               
                sums += nums[i]               
                if res < sums: 
                    continue
                else:
                    start += 1   
                    break                                       
            res = max(res,sums)
        return res