class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if len(strs)<1:
            return ""        
        previous=strs[0]
        n=len(strs)
        for i in range(1,n):
            index=0
            current=strs[i]
            while index<len(current) and index<len(previous) and previous[index]==current[index]:
                index+=1
            previous=current[:index]
        return previous

obj = Solution()
print(obj.longestCommonPrefix(["aabca","aab","aahsjdsj","aa","aahjdskdl","aac"]))
