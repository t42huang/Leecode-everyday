class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        res = 0               
        for num in nums:
            cnt = 0
            while num != 0:
                num //= 10
                cnt += 1
            #the time divided by 10 is even, then the num has even digits 
            if cnt%2 == 0:
                res += 1
        return res
# sol2
        # cnt = 0
        # for num in nums:
        #     if len(str(num)) %2 ==0:
        #         cnt +=1
        # return cnt