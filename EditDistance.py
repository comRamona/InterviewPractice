class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        dp=[]*(len(word1)+1)
        for i in range(len(word1)+1):
            dp.append([0]*(len(word2)+1))
        dp[0][0]=0
        
        for i in range(1,len(word2)+1):
             dp[0][i]=i
        for i in range(1,len(word1)+1):
             dp[i][0]=i
    
        for i in range(1,len(word1)+1):
            for j in range(1,len(word2)+1):
                c_sub=1
                if(word1[i-1]==word2[j-1]):
                    c_sub=0
                dp[i][j] = min(dp[i][j-1]+1,dp[i-1][j]+1,dp[i-1][j-1]+c_sub)
        
        return dp[len(word1)][len(word2)]
