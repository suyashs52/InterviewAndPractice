package learn.thread.structure_concurrency;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LongRunningTaskIntrrupt implements Callable<LongRunningTaskIntrrupt.TaskResposne> {

    private final String name;
    private final int time;
    private final String output;
    private final boolean fail;

    public LongRunningTaskIntrrupt(String name, int time, String output, boolean fail) {
        this.name = name;
        this.time = time;
        this.output = output;
        this.fail = fail;
    }

    record TaskResposne(String name, String response, long timeTaken) {

    }


    @Override
    public TaskResposne call() {
        long startTime = System.currentTimeMillis();
        print("Started");
        int noOfSec = 0;

        while (noOfSec++ < time) {

            if (Thread.interrupted()) // we are responsive during cancellation.
            {
                throwIntrruptedException();
            }
            print("Working..{" + noOfSec + "}");

            try {
                Thread.sleep(Duration.ofSeconds(1)); //this will terinate immediently when intrrupt called
            } catch (InterruptedException e) {
                throwIntrruptedException();
            }

        }

        if (fail) {
            throwExceptionOnFailure();
        }
        print("Completed");

        long endTime = System.currentTimeMillis();
        return new TaskResposne(name, output, endTime - startTime);
    }

    private void throwIntrruptedException() {
        print("Intrrupted ");
        throw new RuntimeException("{" + name + "} : Intrrupted  ");
    }

    private void throwExceptionOnFailure() {
        print("Failed ");
        throw new RuntimeException("{" + name + "} :Failed ");
    }

    private void print(String message) {
        System.out.printf("%s : %s \n", name, message);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main : Started ");
        LongRunningTaskIntrrupt task = new LongRunningTaskIntrrupt("Long Task1", 10, "json-response 1", false);
        try (ExecutorService service = Executors.newFixedThreadPool(2)) {
            Future<TaskResposne> taskFuture = service.submit(task);

            Thread.sleep(Duration.ofSeconds(5));
            taskFuture.cancel(true); //main thread will end in 5 sec , not in 10 secs
            // thread woke up from the sleep and threw an interrupted exception and that's why we did not
            // see the long running task completed message.
            System.out.println("Future Task Main Thread : Completed ");
        }

        System.out.println("Main : Completed ");

    }


}
