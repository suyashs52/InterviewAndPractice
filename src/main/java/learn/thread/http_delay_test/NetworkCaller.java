package learn.thread.http_delay_test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;


public class NetworkCaller {

    private String callName;

    public NetworkCaller(String callName) {
        this.callName = callName;
    }

    public String makeCall(int sec) throws URISyntaxException, IOException {
        System.out.println(String.format("{+" + callName + "} :MAKE CALL: {}", Thread.currentThread()));
        System.out.println();

        URI uri = new URI(String.format("http://httpbin.org/delay/{}", sec));
        try (InputStream stream = uri.toURL().openStream()) {
            return new String(stream.readAllBytes());
        } finally {
            System.out.println(String.format("{+" + callName + "} :End CALL: {}", Thread.currentThread()));


        }
    }
}
