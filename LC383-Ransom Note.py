class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """
#sol1
        for i in ransomNote:
            if i not in magazine:
                return False
            magazine = magazine.replace(i,'',1)
        return True

#sovl2
        # if len(ransomNote) >len(magazine):
        #     return False
        # ransomNote =list(ransomNote)
        # magazine = list(magazine)
        # i = 0
        # cnt = 0
        # while i < len(ransomNote):
        #     if ransomNote[i] in magazine:
        #         magazine.remove(ransomNote[i])
        #         cnt +=1
        #     i +=1
        # if cnt == len(ransomNote):
        #     return True
        # else:
        #     return False

#sol3
        # return not len(Counter(ransomNote) - Counter(magazine))


