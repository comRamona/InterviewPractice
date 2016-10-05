def lps(s):
    n=len(s)
    table=[[False]*n for x in xrange(n)]
    table[n-1][n-1]=True
    result=s[0]
    r=1
    for x in range(0,n-1):
        table[x][x]=True
        if(s[x]==s[x+1]):
            table[x][x+1]=True
            result=s[x:x+2]
            r=2

    for length in range(3,n+1):
        for start in range(0,n-length+1):
            if(s[start]==s[start+length-1]):
                if(table[start+1][start+length-1-1]==True):
                    table[start][start+length-1]=True
                    result=s[start:start+length]
                    r=length

    print r
    return result

print lps("abcdcbba")
print lps("123552")
