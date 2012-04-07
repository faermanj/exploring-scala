object FiboScala extends App {
  def fibo(x: Int): BigInt = {
    var a: BigInt = 0
    var b: BigInt = 1
    var c: BigInt = 0
    for (_ <- 1 to x) {
      c = a + b
      a = b
      b = c
    }
    return a
  }

  println(fibo(1000))
}