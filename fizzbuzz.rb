#!/usr/local/bin/ruby
#FizzBuzz
#Jeffrey Skonhovd
#
i = 1;	
i.upto(100){
	i = i + 1
	if i%3<1 and i%5>1
		puts"fizz-#{i}"
	end 
	if i%5<1 and i%3>1
		puts"buzz-#{i}"
	end 
	if i%15<1
		puts"fizzbuzz-#{i}"
	end 
}
