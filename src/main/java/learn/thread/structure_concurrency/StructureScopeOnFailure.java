package learn.thread.structure_concurrency;

import java.time.Duration;
import java.time.Instant;
import java.util.BitSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;
import java.util.concurrent.TimeoutException;

public class StructureScopeOnFailure<T> {


    public static void main(String[] args) throws Exception {
        System.out.println("Main : Started ");


        exampleCompleteAllTasks();

        System.out.println("Main : Completed ");

    }


    private static void exampleCompleteAllTasks() throws Exception  {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {

            LongRunningTaskIntrrupt expTask = new LongRunningTaskIntrrupt("expedia-task", 3, "100$", true);
            LongRunningTaskIntrrupt hotTask = new LongRunningTaskIntrrupt("hotwire-task", 10, "110$", false);

            //Start running task in parallel
            var expSubTask = scope.fork(expTask);
            var hotSubTask = scope.fork(hotTask);


            //handle child task result
            Subtask.State expState = expSubTask.state();
            Subtask.State hotState = hotSubTask.state();

            scope.join();
            scope.throwIfFailed(); //joined followed by , if any one failed halt other too gracefuly
//the join method would detect that the data task has failed and then we'll send a cancellation
//request to the rest task because its result is no longer needed.
            //shut down on failure is called from the main method here
            scope.throwIfFailed((t)->new Exception(t)); //can thrw specific exception
            //ExecutionException
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
