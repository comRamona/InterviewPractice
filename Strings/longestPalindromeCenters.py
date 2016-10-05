    def helper(s,beg,end):
        #check palindrome around center
        while(beg>=0 and end<len(s) and s[beg]==s[end]):
            beg-=1
            end+=1
    return s[beg+1:end]
    def longest(s):
        if len(s)<2:
            return s
        t=s[:1]
        n=len(s)
        lng=1
        for i in range(0,n):
            tmp=helper(s,i,i)
            if(len(tmp)>len(t)):
                lng=len(tmp)
                t=tmp
            tmp=helper(s,i,i+1)
            if(len(tmp)>len(t)):
                lng=len(tmp)
                t=tmp
        return t

print longest("dabbac")
print longest("pdabbace")
print longest("dabc")
print longest("dabbfc")
