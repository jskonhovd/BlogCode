(* assert method in SML *)

fun assert(expected, function, msg) =
	if((function ()) = expected) 
		then print "Pass"
		else print "Fail"
		
	
