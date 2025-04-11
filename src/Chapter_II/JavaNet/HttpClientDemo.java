package src.Chapter_II.JavaNet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpClientDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create("http://www.duckduckgo.com/");
        HttpRequest request = HttpRequest.newBuilder(uri).build();
        HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
        System.out.println("Response code: " + response.statusCode());
        System.out.println("Request method: " + request.method());
        HttpHeaders headers = response.headers();
        Map<String, List<String>> headersMap = headers.map();
        Set<String> headersFields = headersMap.keySet();
        System.out.println("\nHeaders: ");
        for (String s : headersFields) {
            System.out.println("Key: " + s + " Value: " + headersMap.get(s));
        }
        System.out.println("Body: ");
        InputStream in = response.body();
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
    }
}
