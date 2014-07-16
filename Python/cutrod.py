def cutrod(p,n):
	if n == 0:
		return 0
	q=-100
	for i in range(len(p)):
		q= max(q,p[i] + cutrod(p,n-1))
	return q

p = [4,5,7,1]
n = 4
k = cutrod(p,n)
print k
      
