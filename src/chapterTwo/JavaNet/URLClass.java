package src.chapterTwo.JavaNet;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class URLClass {
    public static void main(String[] args) throws IOException {
        String yt = "http://www.youtube.com";
        String  g = "http://www.google.com";
        URL url = URI.create(yt).toURL();
        System.out.println("Protocol: " + url.getProtocol());
        System.out.println(url.toExternalForm());

        URLConnection uc = url.openConnection();
        System.out.println("Content type" + uc.getContentType());
        long d = uc.getDate();
        if (d == 0) {
            System.out.println("Unavailable");
        } else { System.out.println(new Date(d)); }
        d = uc.getLastModified();
        if (d == 0) {
            System.out.println("Not accessible");
        } else { System.out.println(d); }
        d = uc.getContentLengthLong();
        System.out.println(d);
        System.out.println();

        HttpURLConnection huc = (HttpURLConnection) URI.create(g).toURL().openConnection();
        System.out.println("Response code: " + huc.getResponseCode() + "\nMessage: " + huc.getResponseMessage() + "\nMethod: " + huc.getRequestMethod() + "\n");
        Map<String, List<String>> fields = huc.getHeaderFields();
        Set<String> list = fields.keySet();
        for(String s : list) {
            System.out.println("Key: " + s + ". Value: " + fields.get(s));
        }

    }
}
