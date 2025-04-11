package src.Chapter_II.JavaNet;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpClientDemo2_ds {
    private final static String TARGET_URL = "httP://www.vk.ru/";
    private final static int BUFFER_SIZE = 1024;
    private final static int TIMEOUT_SECONDS = 5;
    public static void main(String[] args) {
        HttpClient httpClient = createHttpClient();
        HttpRequest request = createHttpRequest();

        try {
            HttpResponse<InputStream> response = sendRequest(httpClient, request);
            processResponse(response);
        } catch (IOException | InterruptedException e) {
            handleError(e);
        }
    }

    private static HttpClient createHttpClient() {
        return HttpClient.newBuilder().connectTimeout(Duration
                .ofSeconds(TIMEOUT_SECONDS))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
    }
    private static HttpRequest createHttpRequest() {
        return HttpRequest.newBuilder().uri(URI.create(TARGET_URL))
                .timeout(Duration.ofSeconds(TIMEOUT_SECONDS))
                .GET()
                .build();
    }

    private static HttpResponse<InputStream> sendRequest(@NotNull HttpClient httpClient, HttpRequest request)
            throws IOException, InterruptedException {
        return httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());
    }
    private static void processResponse(HttpResponse<InputStream> response) throws IOException {
        printStatusAndMethod(response);
        printHeaders(response.headers());
        printResponseBody(response.body());
    }

    private static void printStatusAndMethod(@NotNull HttpResponse<?> response) {
        System.out.printf("Response code: %d%n", response.statusCode());
        System.out.printf("Request method: %s%n%n", response.request().method());
    }

    private static void printHeaders(@NotNull HttpHeaders headers) {
        System.out.println("Headers:");
        headers.map().forEach((key, values) ->
                System.out.printf("  %s: %s%n", key, String.join(", ", values)));
        System.out.println();
    }

    private static void printResponseBody(@NotNull InputStream bodyStream) throws IOException {
        System.out.println("Body (first 1000 chars):");
        byte[] buffer = new byte[BUFFER_SIZE];
        int totalRead = 0;
        int bytesRead;

        while ((bytesRead = bodyStream.read(buffer)) != -1 && totalRead < 1000) {
            System.out.print(new String(buffer, 0, Math.min(bytesRead, 1000 - totalRead)));
            totalRead += bytesRead;
        }

        if (bodyStream.available() > 0) {
            System.out.printf("%n... [truncated, total %d bytes remaining]%n", bodyStream.available());
        }

        bodyStream.close();
    }

    private static void handleError(@NotNull Exception e) {
        System.err.println("Error occurred during HTTP request:");
        e.printStackTrace();
        if (e instanceof InterruptedException) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }
}
