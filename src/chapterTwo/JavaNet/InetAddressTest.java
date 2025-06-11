package src.chapterTwo.JavaNet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);
        address = InetAddress.getByName("www.duckduckgo.com");
        System.out.println(address);

        InetAddress[] addresses = InetAddress.getAllByName("www.ya.ru");
        for (InetAddress inetAddress : addresses) {
            System.out.println(inetAddress);
        }
    }
}
