import collection.JavaConverters._
import java.net.NetworkInterface

object ListMACsForScala extends App {
  val nicaddresses = for {
    nic <- NetworkInterface.getNetworkInterfaces.asScala
    addrbytes <- Option(nic.getHardwareAddress)
  } yield {
    addrbytes map { "%02x" format _ } mkString ":"
  }
  nicaddresses foreach println
} 