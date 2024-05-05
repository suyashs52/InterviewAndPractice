package learn.thread.structure_concurrency;

import java.time.Duration;
import java.time.Instant;
import java.util.BitSet;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;
import java.util.concurrent.TimeoutException;

public class StructureScope<T> {


    public static void main(String[] args) throws Exception {
        System.out.println("Main : Started ");

        interruptMain();
        exampleCompleteAllTasks();

        System.out.println("Main : Completed ");

    }

    private static void interruptMain() {
        //child tread of StructuredTaskScope interrupted too
        Thread mainThread = Thread.currentThread();
        Thread.ofPlatform().start(() -> {
            try {
                Thread.sleep(Duration.ofSeconds(1));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            mainThread.interrupt();
        });
    }

    private static void exampleCompleteAllTasks() throws InterruptedException, TimeoutException {
        try (var scope = new StructuredTaskScope<LongRunningTaskIntrrupt.TaskResposne>()) {
            // LongRunningTaskIntrrupt expTask = new LongRunningTaskIntrrupt("expedia-task", 3, "100$", false);
            //3 sec after failed
            LongRunningTaskIntrrupt expTask = new LongRunningTaskIntrrupt("expedia-task", 3, "100$", true);
            LongRunningTaskIntrrupt hotTask = new LongRunningTaskIntrrupt("hotwire-task", 10, "110$", false);

            //Start running task in parallel
            var expSubTask = scope.fork(expTask);
            var hotSubTask = scope.fork(hotTask);
//            if (true)
//                throw new RuntimeException("Some Exception !"); //if exception both task interrupted


            //wait for all task to complete
            // scope.join(); // join will wait for both tasks to complete, no matter what success or failure.
            scope.joinUntil(Instant.now().plus(Duration.ofSeconds(2))); // will send a cancellation request to both the tasks after timeout


            //handle child task result
            Subtask.State expState = expSubTask.state();
            Subtask.State hotState = hotSubTask.state();

            if (expState == Subtask.State.SUCCESS) {
                System.out.println(expSubTask.get());
            } else if (expState == Subtask.State.FAILED) {
                System.out.println(expSubTask.exception());
            }


            if (hotState == Subtask.State.SUCCESS) {
                System.out.println(hotSubTask.get());
            } else if (hotState == Subtask.State.FAILED) {
                System.out.println(hotSubTask.exception());
            }


        }
    }

}
