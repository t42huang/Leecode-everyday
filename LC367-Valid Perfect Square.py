class Solution(object):
    def isPerfectSquare(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num < 2:
            return True
        l = 0 
        r = num // 2 
        while l <= r:
            mid = l + (r-l)//2
            square = mid**2
            if square == num:
                return True
            if square > num:
                r = mid - 1
            else:
                l = mid + 1
        return False
        