
#! /usr/bin/python
#FizzBuzz
#Jeffrey Skonhovd
#
i = 1;
for i in range(i,101):
	if(i%3==0 and i%5!=0):
		print("----fizz----- ", i)
	if(i%5==0 and i%3!=0):
		print("----buzz---- ", i)
	if(i%15==0):
		print("----fizzbuzz---", i)


