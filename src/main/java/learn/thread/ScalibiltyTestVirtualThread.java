package learn.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;


public class ScalibiltyTestVirtualThread {


    private static void handleUserRequest() {
        System.out.println(String.format("Starting Thread: {}",Thread.currentThread()));
        try {
            Thread.sleep(1000); //1 sec sleep
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(String.format("Ending Thread: {}",Thread.currentThread()));
    }
//
//    public static void main(String[] args) {
//        System.out.println("Starting Main ");
//
//        int n = 10000;//1000;//10; //thread working on this
//        //by default virtual thread is daemon thread terminates when main exits so jvm shuts down
//        //race condition becuase we don't know how far virtual thread has gone for when main thread terminated so slight
//        //race condition
//        for (int i = 0; i < n; i++) {
//
//            startThread();
//        }
//
//        System.out.println("Ending Main");
//    }
//
//    private static void startThread() {
//        // VirtualThread[#3428]/runnable@ForkJoinPool-1-worker-1
//        Thread.startVirtualThread(() -> handleUserRequest());
//    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting Main ");

        int n = 10_00_000;//1000;//10; //thread working on this

        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            list.add(startThread());
        }

        //join on thread
        for (Thread th : list) {
            th.join();
        }
        System.out.println("Ending Main");
    }

    private static Thread startThread() {
        // VirtualThread[#3428]/runnable@ForkJoinPool-1-worker-1
        // return Thread.startVirtualThread(() -> handleUserRequest());
//create a virtual builder object  with name and intital index
//        Thread.Builder.OfVirtual userThread = Thread.ofVirtual().name("UserThread", 0);
//        Thread th=userThread.start(ScalibiltyTestVirtualThread::handleUserRequest); //create a thread from builder
//        return th;

        //create thread factory out of builder
        ThreadFactory factory = Thread.ofVirtual().name("user thread", 0).factory();
        Thread th1 = factory.newThread(ScalibiltyTestVirtualThread::handleUserRequest);
        Thread th2 = factory.newThread(ScalibiltyTestVirtualThread::handleUserRequest);

// Create an Virtual Thread ExecutorService
// Note the try with resource which will make sure all Virtual threads
// are terminated
        try (ExecutorService es = Executors.newVirtualThreadPerTaskExecutor()) {
            es.submit(ScalibiltyTestVirtualThread::handleUserRequest);
            es.submit(ScalibiltyTestVirtualThread::handleUserRequest);


        }

        try (ExecutorService es = Executors.newThreadPerTaskExecutor(factory)) {
            es.submit(ScalibiltyTestVirtualThread::handleUserRequest);
            es.submit(ScalibiltyTestVirtualThread::handleUserRequest);


        }
        return th1;
    }
}
