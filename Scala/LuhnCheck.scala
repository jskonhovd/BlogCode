package code

object LuhnCheck {
  
  def luhnDoubleOddNumber(a: List[Integer]): List[Integer] = {
    	def helper(foo: List[Integer], acc: Integer):List[Integer] = {
    			foo match {
    			case List() => List()
    			case x::xs => if(acc%2 != 0) (2*x)::helper(xs,acc+1)
      		   			  	  else x::helper(xs,acc+1)
      		   }
    	}
    helper(a, 0)
  }                                               //> luhnDoubleOddNumber: (a: List[Integer])List[Integer]
    
     
  
  def integerBreakDown(a: Integer):List[Integer] = {
    def helper(i : Integer):List[Integer] = {
      if(i > 9)
      {
        (i%10)::helper(i/10)
      }
      else
      {
        List(i%10)
      }
      
    }
    helper(a)
  }                                               //> integerBreakDown: (a: Integer)List[Integer]
  
  def luhnList(a: List[Integer]):List[Integer] = { a match {
    case List() => List()
    case x::xs => if(x > 9) integerBreakDown(x).reverse:::luhnList(xs)
    			  else integerBreakDown(x).reverse:::luhnList(xs)
  }
  }                                               //> luhnList: (a: List[Integer])List[Integer]
  
  def sumLuhn(a:List[Integer]): Integer = { a match {
    case List() => 0
    case x::xs => x+sumLuhn(xs)
  }
    
  }                                               //> sumLuhn: (a: List[Integer])Integer
  
  def checkLuhn(a : List[Integer]): Boolean = {
    if(sumLuhn((luhnList(luhnDoubleOddNumber(a.reverse)))) % 10 == 0) true
    else false
  }   
  
  def isThisAllIntegers(str : String):Boolean = {
    def helper(charList: List[Char]): Boolean = { charList match {
        case List() => true
        case x::xs => if (x.isDigit) helper(xs)
        			  else false
        }     
    }
    helper(str.toList)
  }
  
  def convertCharListToIntegerList(charList: List[Char]):List[Integer] = {
    charList match {
      case List() => List()
      case x::xs => x.toInt::convertCharListToIntegerList(xs)
    }
    
  }
  
  def bruteString(str: String): String= {
    def helper(substr: String): Boolean  = {
      val bool16 = if(isThisAllIntegers(substr.substring(0, 15))) checkLuhn(convertCharListToIntegerList(substr.substring(0, 15).toList))
    		  	   else false
      val bool15 = if(isThisAllIntegers(substr.substring(0, 14))) checkLuhn(convertCharListToIntegerList(substr.substring(0, 14).toList))
    		  	   else false//checkLuhn()
      val bool14 = if(isThisAllIntegers(substr.substring(0, 13))) checkLuhn(convertCharListToIntegerList(substr.substring(0, 13).toList))
    		  	   else false
    		  	   
      if(bool16 == true) true
      else if (bool15 == true) true
      else if (bool14 == true) true
      else false
    }
    
    def replaceCharWithX(str : List[Char], lo: Int, high: Int, acc: Int): List[Char] = {
      str match {
        case List() => List()
        case x::xs => if(acc >= high || acc <= lo)  if (x.equals('-') || x.equals(' ')) replaceCharWithX(x::xs,lo,high,acc+1)
        											else replaceCharWithX('X'::xs,lo,high,acc+1)
        			  else replaceCharWithX(x::xs,lo,high,acc+1)
        
      }
    }
    
    def removeSpaceAndDash(str: String) = str.replace(" ", "").replace("-", "")
    
    def runBrute(lo: Int, hi: Int, str: String): String = {
      if(hi >= str.length())
      {
        str
      }
      else
      {
        if(removeSpaceAndDash(str.substring(lo, hi)).length() < 16)
        {
          runBrute(lo,hi+1,str)
        }
        else if(removeSpaceAndDash(str.substring(lo, hi)).length() == 16)
        {
          if(helper(removeSpaceAndDash(str.substring(lo, hi)))) 
          {           
            runBrute(lo+1,hi+1, replaceCharWithX(str.toList,lo,hi,0).toString)
          }
          else
          {
            runBrute(lo+1,hi+1, str)
          }
        }
        else 
        {
          runBrute(lo+1,hi, str)
        }
      }
      
    }
    
    runBrute(0,14,str)
  }
  
  def main(args: Array[String]): Unit = {
    println(checkLuhn(List(5,6,7,8)))
    println(checkLuhn(List(5,6,6,1,3,9,5,9,9,3,2,5,3,7)))
    println(checkLuhn(List(12, 7, 16, 9)))
    println(bruteString("4111 1111 1111 1111"))
    
    
  }
  

}