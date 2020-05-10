class Solution(object):
    def findJudge(self, N, trust):
        """
        :type N: int
        :type trust: List[List[int]]
        :rtype: int
        """
        m = len(trust)
        arr1 = [0 for _ in range(N+1)] #count the be trusted val's number
        arr2 = [0 for _ in range(N+1)] #count one trust others's number
        k = 1 # arr1[k], k, who gets most turst index
        for i in range(m):
            a = trust[i][0]
            b = trust[i][1]
            
            arr1[b] += 1
            arr2[a] += 1
            if arr1[k] < arr1[b]:
                k = b
        if arr1[k] == N-1 and arr2[k] == 0:
            return k
        else: 
            return -1
           
        