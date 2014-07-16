def bottomUpCutRod(p,n):
    r = range(n+1)
    r[0] = 0
    j = 1
    for j in range(n):
        q = -100
        for i in range(j):
            q = max(q,p[i] + r[j-i])
        r[j] = q 
    return r[n]

p = [0,1,5,8,9,10,17,17,20,24,30]
n = 10
k = bottomUpCutRod(p,n)
print k
