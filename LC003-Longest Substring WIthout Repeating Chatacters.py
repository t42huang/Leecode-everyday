class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """ 
#sol1, iteration
#         res = 0
#         substr = set()
#         r = 0
#         for i in range(len(s)):
#             if i != 0:
#                 substr.remove(s[i-1])
#             while r < len(s) and s[r] not in substr:
#                 substr.add(s[r])
#                 r += 1
                
#             res = max(res, r-i)
#         return res
# sol2 using square box   
        start, end, length = 0, 0, 0
        res = 0
        
        while end < len(s):
            # restore the value
            temp = s[end]
            for i in range(start, end):
                if s[i] == temp:
                    start = i + 1
                    length = end - start
                    break
            end += 1
            length +=1
            res = max(res, length)
        return res
        
                
            
        