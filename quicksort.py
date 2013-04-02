#! /usr/bin/python
#Quicksort
#Jeffrey Skonhovd
#
from random import randrange  
n = [4,5,7,1,8,4,1,77,283,3,2,32,44,25,63,5,646,5,74,757]
b = [4,5,6,7,8,4,23,24,5,2,999]

def quicksort(x):
	lesser = []
	greater = []
	val = []
	if x ==  []:
		return []
	else:			
		pivot = x.pop(randrange(len(x)))
		print 'pivot', pivot
		i = 0
		for i in range(len(x)):  #Tranversing the list making 2 more lists
			if x[i] < pivot:
				print "Greater Than ", x[i]
				lesser.append(x[i])
			if x[i] >= pivot:
				print "Less Than ", x[i]
				greater.append(x[i])			
		return quicksort(lesser) + [pivot] + quicksort(greater)
	return quicksort(x[:])





def sum(n1, n2):
    return n1 + n2

a = reduce(sum, [n,b])

k = quicksort(a)
for i in range(len(a)):
	print k[i]

print k
