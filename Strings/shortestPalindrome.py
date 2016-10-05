class Solution(object):
    def shortestPalindrome(self,s):
        n=len(s)
        longest=1
        for length in range(n,1,-1):
            rev=s[0:length]
            if rev==rev[::-1]:
                longest=length
                break
        print longest
        suffix=s[longest:]
        print suffix
        prefix=suffix[::-1]
        result=prefix+s
        return result

    def centers(self,s,beg,end):
        while(beg>=0 and end<len(s) and s[beg]==s[end]):
            beg-=1
            end+=1
        if beg==-1:
            return end
        else:
            return None

    def shortestPalindromeCenters(self,s):
       if len(s)<2:
           return s
       mid=len(s)/2
       for i in range(mid,-1,-1):
           end=self.centers(s,i,i+1)
           if(end!=None):
               suffix=s[end:]
               prefix=suffix[::-1]
               return prefix+s
           end=self.centers(s,i,i)
           if(end!=None):
               suffix=s[end:]
               prefix=suffix[::-1]
               return prefix+s
       return ""



obj=Solution()
print obj.shortestPalindromeCenters("cabba")
print obj.shortestPalindromeCenters("c")
print obj.shortestPalindromeCenters("aba")
print obj.shortestPalindromeCenters("aabba")
