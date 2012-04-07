import org.apache.commons.collections.CollectionUtils._
import org.apache.commons.collections._
import scala.collection.JavaConversions._

object Colecoes extends App {
  val myList = List.range(-5, 5)

  forAllDo(
    collect(
      select(myList,
        new Predicate {
          def evaluate(obj: Object): Boolean =
            return obj.asInstanceOf[Int] > 0
        }),
      new Transformer {
        def transform(obj: Object): Object = {
          return (2 * obj.asInstanceOf[Int])
            .asInstanceOf[Object]
        }
      }),
    new Closure {
      def execute(obj: Object) {
        println(obj)
      }
    })

  myList filter(_ > 0) map(_ * 2) foreach println

}