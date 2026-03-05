package practice2.task4;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpTask {

    public static void main(String[] args) throws Exception {
        HttpClient cli = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/anything"))
                .header("Accept", "application/json")
                .build();

        HttpResponse<String> res = cli.send(req, HttpResponse.BodyHandlers.ofString());
        String body = res.body();

        ObjectMapper map = new ObjectMapper();
        JsonNode root = map.readTree(body);
        JsonNode h = root.get("headers");

        if (h != null && h.has("Accept")) {
            String acc = h.get("Accept").asText();
            System.out.println("Accept: " + acc);
        } else {
            System.out.println("Polya Accept ne naideno");
        }
    }
}