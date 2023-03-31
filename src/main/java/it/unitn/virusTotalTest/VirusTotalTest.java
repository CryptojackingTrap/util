package it.unitn.virusTotalTest;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

import java.io.IOException;

public class VirusTotalTest {
    public static void main(String[] args) throws IOException {
        AsyncHttpClient client = new DefaultAsyncHttpClient();
        String hash = "b6cd59f6db5d8795b9859ad86cd555f508f52af4a030407ba5296f3790d2bc41";
        String apiKey = "e5e50e5c69332a241e16e90574a17512ea7c647e0851bfe950123b602cf23c3d";
        client.prepare("GET", "https://www.virustotal.com/api/v3/monitor_partner/files/"+hash+"/download")
                .setHeader("x-apikey", apiKey)
                .setHeader("X-Apikey", apiKey )
                .execute()
                .toCompletableFuture()
                .thenAccept(System.out::println)
                .join();

        client.close();
    }
}
