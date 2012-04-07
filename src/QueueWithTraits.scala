import scala.collection.mutable.ArrayBuffer

//Type Definition
abstract class IntQueue {
  def get(): Int
  def put(x: Int)
  def size(): Int
}

//ArrayBuffer implementation
class IntQueueImpl extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get = buf remove 0
  def put(x: Int) { buf += x }
  def size = buf length
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int) {
    super.put(2 * x) 
    }
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) {
    super.put(x + 1)
  }
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) {
    if (x > 0) super.put(x)
  }
}

//Mixing traits in type definition
class DoublePlusOneQueue extends IntQueueImpl with Incrementing with Doubling

object FilaComTrait {
  def main(args: Array[String]) {
    val queue1 = new DoublePlusOneQueue
    queue1 put 1
    queue1 put 2
    println(queue1 get)
    println(queue1 get)

    //Mixing traits in object instantiation
    val queue2 = new IntQueueImpl with Filtering
    queue2 put -1
    queue2 put 1
    println(queue2 size)
  }
}