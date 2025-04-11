package src.Chapter_II.JavaNet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClass {
    public static void main(String[] args) {
        String host = "www.google.ru";
        int port = 443;

        try (Socket s = new Socket(host, port)){ // Порт https
            s.setSoTimeout(5000);
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            String request = "Get / HTTP/1.1\r\nHost: www.google.com\r\nConnection: close\r\n\r\n";
            out.write(request.getBytes());
            out.flush();
            p("Port: " + s.getSoTimeout());
            int c;
            while ((c = in.read()) != -1) { System.out.print((char) c); }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static void p(String s) {
        System.out.println(s);
    }
}
