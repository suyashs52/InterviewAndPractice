package learn.thread.http_delay_test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.IntStream;

public class HttpPlay {

    public static final int NUMS_USER = 500;//2; //500; //3000; //no problem at all

    public static void main(String[] args) {

        ThreadFactory threadFactory = Thread.ofVirtual().name("request-handler-", 0).factory();
        ThreadFactory plateformThreadFactory = Thread.ofPlatform().name("request-handler-", 0).factory(); //worked by thread class
        //if we use
        //     Executors.newFixedThreadPool(500,plateformThreadFactory); thaen for 5000 it won't break as we are not
        //  creating new threads if required' but it will be slower
        //if other user connecting they will get time out

//        try (ExecutorService executor = Executors.newFixedThreadPool(100, plateformThreadFactory)) {
//            IntStream.range(0, NUMS_USER).forEach(j -> {
//                executor.submit(new UserRequestHandler());
//
//            });
//        }
        try (ExecutorService executor = Executors.newThreadPerTaskExecutor(threadFactory)) {
            IntStream.range(0, NUMS_USER).forEach(j -> {
                executor.submit(new UserRequestHandler());

            });
        }
        //main thread is waiting at try with resource executer.close() called, so waiting till all thread are terminated,
        //
    }
}
