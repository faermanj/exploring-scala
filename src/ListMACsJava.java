import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class ListMACsJava {
    public static void main(String[] args) throws SocketException {
        for (NetworkInterface nic : Collections.list(NetworkInterface.getNetworkInterfaces())) {
            byte[] mac = nic.getHardwareAddress();
            for (int i = 0; mac != null && i < mac.length; i++) {
                System.out.format("%2x", mac[i]);
                System.out.print(i == mac.length - 1 ? '\n' : ':');
            }
        }
    }
}