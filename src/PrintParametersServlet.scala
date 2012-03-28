import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.annotation.WebServlet
import scala.collection.JavaConversions._

@WebServlet(Array("/mostraParams"))
class PrintParametersServlet extends HttpServlet {
  override def doGet(req: HttpServletRequest,
    resp: HttpServletResponse) {  
    val out = resp.getWriter();
    req.getParameterMap()
      .map {case (chave, valor) => chave +" = "+ valor.mkString(",")}
      .foreach(out.println(_))
  }
}