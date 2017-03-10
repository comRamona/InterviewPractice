https://leetcode.com/problems/word-break/?tab=Description

from sets import Set
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        self.mem=Set()
        self.dic=Set(wordDict)
        return self.splitty(s)
        
        
    def splitty(self,s):
        dp=[False]*(len(s)+1)
        dp[0]=True
        for i in range (1,len(s)+1):
            for j in range(0,i):
                if(dp[j] and s[j:i] in self.dic):
                    dp[i]=True
                    break
        return dp[-1]
        
