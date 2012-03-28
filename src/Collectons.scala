import org.apache.commons.collections.CollectionUtils
import org.apache.commons.collections.Predicate
import scala.collection.JavaConversions._
import org.apache.commons.collections.Transformer
import java.lang.Object
import org.apache.commons.collections.Closure

object Colecoes extends Application {
  val myList = List.range(-5, 5)

  CollectionUtils.forAllDo(
    CollectionUtils.collect(
      CollectionUtils.select(myList,
        new Predicate() {
          def evaluate(obj: Object): Boolean =
            return obj.asInstanceOf[Int] > 0;
        }), new Transformer() {
        def transform(obj: Object): Object = {
          return (2 * obj.asInstanceOf[Int])
            .asInstanceOf[Object];
        }
      }),
    new Closure() {
      def execute(obj: Object) {
        println(obj);
      }
    })

  myList.filter(_ > 0).map(_ * 2).foreach(println(_));

}