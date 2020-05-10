class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if len(nums) == 0:
            return False
        
        # return len(nums) > len(set(nums))
    
        # a = collections.Counter(nums)
        # for i in range(len(nums)):
        #     if a[nums[i]] > 1:
        #         return True            
        # return False 

#         dic={}        
#         for n in nums:
#             if n in dic:
#                 return True               
#             else:
#                 dic[n]= 1            
#         return False
        
        
        # for i in nums:
        #     nums.remove(i)
        #     if i in nums:
        #         return True
        # return False
            
#         not good, append takes time
        # temp =[]
        # for i in range(0,len(nums)):
        #     if nums[i] in temp:
        #         return True
        #     else:
        #         temp.append(nums[i])
        # return False
        