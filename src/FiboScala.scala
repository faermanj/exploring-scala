object FiboScala {
	def fibo(x:Int):BigInt = {
		  var a:BigInt = 0;
		  var b:BigInt = 1;
		  var c:BigInt = 0;
		  for(_ <- 1 to x){			 
			  c = a+b;
			  a = b;
			  b = c;
		  }
	      return a;
	  }
	  
	def main(args: Array[String]) = println(fibo(1000))
}