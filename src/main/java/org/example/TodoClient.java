package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class TodoClient {
    private final String URL = "";
    private final HttpClient client;

    public TodoClient() {
        client = HttpClient.newHttpClient();
    }

    public void request() throws Exception {
        Path filePath = Path.of("C:/videos/sample.mp4");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("Content-Type", "video/mp4") // указываем тип данных
                .POST(HttpRequest.BodyPublishers.ofFile(filePath))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
