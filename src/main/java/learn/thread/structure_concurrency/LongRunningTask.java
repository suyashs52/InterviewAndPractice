package learn.thread.structure_concurrency;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LongRunningTask implements Callable<LongRunningTask.TaskResposne> {

    record TaskResposne(String resonse) {

    }


    @Override
    public TaskResposne call() throws Exception {
        System.out.println("Long Runing Task : Started ");

        Thread.sleep(Duration.ofSeconds(10)); //this will terinate immediently when intrrupt called
        System.out.println("Long Runing Task : Completed  ");

        return new TaskResposne("Done");
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main : Started ");
        LongRunningTask task=new LongRunningTask();
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
