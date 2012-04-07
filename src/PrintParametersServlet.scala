import javax.servlet.http._
import javax.servlet.annotation.WebServlet
import scala.collection.JavaConversions._

@WebServlet(Array("/mostraParams"))
class PrintParametersServlet extends HttpServlet {
  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) {
    val out = resp.getWriter
    req.getParameterMap
      .map { case (key, value) => key + " = " + value.mkString(",") }
      .foreach(out println _)
  }
}