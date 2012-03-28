import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class ListMACsJava {
	public static void main(String[] args) {
		try {
			Enumeration<NetworkInterface> nics = 
						NetworkInterface.getNetworkInterfaces();
			while(nics.hasMoreElements()){
				NetworkInterface nic = nics.nextElement();
				byte[] mac = nic.getHardwareAddress();
				String macStr = "";
				if (mac != null)
					for (int i = 0; i < mac.length; i++) {
						macStr += String.format("%02x", mac[i]);
						if(i < mac.length-1) macStr += ":";
					}
				System.out.println(macStr);
			}
		} catch (SocketException e) {
			System.err.println("Ooops!");
		}
	}
}