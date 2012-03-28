object FiboFunctional {
  val fibs:Stream[BigInt] =
    0 #:: 1 #:: (fibs zip fibs.tail).map{ case (a,b) => a+b }
  def main(args: Array[String]) = println(fibs(1000));
}