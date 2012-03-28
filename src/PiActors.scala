import scala.util.Random
import Math._
import System._
import scala.actors.Actor
import scala.actors.Actor._

case object Calculate
case object ShutDown

class Calculator extends Actor {
  val rand = new Random
  var pi, in, cnt = 1.0

  def act() {
    while (true) {
      receive {
        case Calculate =>
          sender ! estimativeOfPi
        case ShutDown => exit
      }
    }
  }

  def estimativeOfPi: Double = {
    val x = rand.nextDouble - 0.5
    val y = rand.nextDouble - 0.5
    cnt += 1.0;
    if (sqrt(x * x + y * y) < 0.5) in += 1
    return in / cnt * 4
  }
}

class Coordinator(numOfCalculators: Int) extends Actor {
  def act() {
    val startedAt = currentTimeMillis
    var calculators = List.fill(numOfCalculators)(new Calculator)
    calculators.foreach(c => {
        c.start
        c ! Calculate
    })
    while (true) {
      receive {
        case estimative: Double =>
          val error = abs(Pi - estimative)
          if (error > 0.0000001)
            sender ! Calculate
          else {
            val tempo = currentTimeMillis - startedAt
            calculators.foreach(_ ! ShutDown)                        
            println("Pi found by " + sender + " = " + estimative)
            println("Execution time: " + tempo)
            exit
          }
      }
    }
  }
}

object PiActors {
  def main(args: Array[String]) {
    new Coordinator(2).start
  }
}