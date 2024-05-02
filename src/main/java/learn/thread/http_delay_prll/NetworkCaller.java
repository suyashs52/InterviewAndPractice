package learn.thread.http_delay_prll;

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
        System.out.println(STR."\{callName} :MAKE CALL: \{Thread.currentThread()}");

        URI uri = new URI(STR."http://httpbin.org/delay/\{sec}");
        try (InputStream stream = uri.toURL().openStream()) {
            return new String(stream.readAllBytes());
        }finally {
            System.out.println(STR."\{callName} :END  CALL: \{Thread.currentThread()}");

        }
    }
}
