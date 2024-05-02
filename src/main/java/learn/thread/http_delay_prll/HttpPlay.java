package learn.thread.http_delay_prll;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.IntStream;

public class HttpPlay {

    public static final int NUMS_USER = 1;//2; //500; //3000; //no problem at all

    public static void main(String[] args) {
        //run UserRequestHandler db , rest call in parallel
        ThreadFactory threadFactory = Thread.ofVirtual().name("request-handler-", 0).factory();

        try (ExecutorService executor = Executors.newThreadPerTaskExecutor(threadFactory)) {
            IntStream.range(0, NUMS_USER).forEach(j -> {
                executor.submit(new UserRequestHandler());

            });
        }

    }
}
