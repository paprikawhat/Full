package src.Chapter_II.JavaNet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class WriteServer {
    public static int serverPort = 998;
    public static int clientPort = 999;
    public static int buffer_size = 1024;
    public static DatagramSocket ds;
    public static byte[] buffer = new byte[buffer_size];

    public static void TheServer() throws IOException {
        System.out.println("Server is running. (Ctrl+C to exit)");
        System.out.println();
        int pos = 0;
        while (true) {
            if(System.in.available() > 0) {
                int c = System.in.read();
                switch (c) {
                    case '\r' -> {}
                    case '\n' -> {
                        ds.send(new DatagramPacket(buffer, pos, InetAddress.getLocalHost(), clientPort));
                        pos = 0;
                    }
                    case -1 -> {
                        System.out.println("Server shutdown session");
                        ds.close();
                        return;
                    }
                    default -> buffer[pos++] = (byte) c;
                }
            }
        }
    }
    public static void TheClient() throws IOException {
        System.out.println("Client is waiting. (Ctrl+C to close)");
        while (true) {
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            ds.receive(p);
            System.out.println("Recived: " + new String(p.getData(), 0, p.getLength()));
        }
    }
    public static void main(String[] args) throws IOException {
        if(args.length == 1) {
            ds = new DatagramSocket(serverPort);
            TheServer();
        } else {
            ds = new DatagramSocket(clientPort);
            TheClient();
        }
    }
}
