class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        cnt = 0
        temp = 0
        for i in nums:
            if cnt == 0:
                temp = i
            
            if temp == i:
                cnt += 1
            else:
                cnt -= 1
        return temp