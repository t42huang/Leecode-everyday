class Solution(object):
    def checkStraightLine(self, coordinates):
        """
        :type coordinates: List[List[int]]
        :rtype: bool
        """
        m = len(coordinates)
        if m < 2:
            return False
        if m == 2:
            return True
        cnt = 0
        for i in range(1,m):
            if (coordinates[1][1] - coordinates[0][1]) * (coordinates[i][0] - coordinates[i-1][0])  == (coordinates[i][1] - coordinates[i-1][1]) *(coordinates[1][0] - coordinates[0][0]):           
                cnt += 1
                continue
            else:
                return False
        if cnt == m-1:
            return True
        