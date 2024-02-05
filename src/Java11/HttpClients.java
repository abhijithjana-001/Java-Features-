package Java11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public class HttpClients {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        // Create an instance of HttpClient
        HttpClient httpClient=HttpClient.newHttpClient();

        // Build a GET request for the specified URI
        HttpRequest request = HttpRequest.newBuilder(
                URI.create("https://openlibrary.org/books/OL1M/lists.json")
        ).GET().build();

        // Send a synchronous GET request and get the response
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        // Send an asynchronous GET request and handle the response using CompletableFuture
        CompletableFuture<HttpResponse<String>> completableFuture = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        // Handle the asynchronous response when it completes
        completableFuture.thenAccept(res-> System.out.println(res.body()));

        // Wait for the asynchronous operation to complete
        completableFuture.get();

    }
}
