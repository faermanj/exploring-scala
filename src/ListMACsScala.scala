import java.net.NetworkInterface
import scala.collection.JavaConversions._

object ListMACsScala {
	def main(args: Array[String]) {
		NetworkInterface
			.getNetworkInterfaces
			.flatMap(nic => Option(nic.getHardwareAddress))
			.map(_ map("%02x" format _) mkString ":")
			.foreach(println(_));
	}
}