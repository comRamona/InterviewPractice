def lcs(s1,s2):
    table=[[0]*(1+len(s2)) for x in xrange(1+len(s1))]
    maxLen=0
    res=""
    for i in range (1,len(s1)+1):
        for j in range (1,len(s2)+1):
            if(s1[i-1]==s2[j-1]):
                table[i][j]=table[i-1][j-1]+1
                if table[i][j]>maxLen:
                    maxLen=table[i][j]
                    res=s1[i-maxLen:i]
    print maxLen
    return res


print lcs("abac","babac")

print lcs("ababc","babac")
