class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if len(matrix) == 0 or matrix ==None:
            return 0
                    
        m = len(matrix) 
        n = len(matrix[0]) 
        size =[[0 for i in range(n+1)] for j in range(m+1)]
      
        res = 0
        for i in range(1, m+1):
            for j in range(1, n+1):               
                if matrix[i-1][j-1] == '1':
                    size[i][j] = min(min(size[i-1][j],size[i][j-1]), size[i-1][j-1]) +1
                    res = max(res, size[i][j])                  
        return pow(res,2)
    
#         n, m = len(matrix), len(matrix[0])        
#         dp = [[0 for i in range(m+1)] for j in range(n+1)]       
#         max_square = 0
#         for i in range(1, n+1):
#             for j in range(1, m+1):
#                 if matrix[i-1][j-1] == "1":
#                     dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
#                     max_square = max(max_square, dp[i][j])    
#         return max_square ** 2
    
# #         m = len(matrix) 
# #         n = len(matrix[0]) 
# #         size =[[0 for i in range(m+1)] for j in range(n+1)]
# #         res = 0

# #         for i in range(0, m):
# #             for j in range(0, n): 

# #                 if matrix[i][j] == '1':
#                     res = 1
#                 if size[i][j] == 0:
#                     continue
#                 elif i == 0:
#                     size[i][j] = size[i][j-1] +1
#                 elif j == 0:
#                     size[i][j] = size[i-1][j] +1
#                 elif matrix[i-1][j-1] == '1':
#                     size[i][j] = min(min(size[i-1][j],size[i][j-1]), size[i-1][j-1]) +1
#                 res = max(res, size[i][j])
                   
#         return pow(res,2)        