package learn.thread.structure_concurrency;

import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;

public class StructureScopeOnSuccess<T> {


    public static void main(String[] args) throws Exception {
        System.out.println("Main : Started ");


        exampleCompleteAllTasks();

        System.out.println("Main : Completed ");

    }


    private static void exampleCompleteAllTasks() throws Exception  {
        try (var scope = new StructuredTaskScope.ShutdownOnSuccess<LongRunningTaskIntrrupt.TaskResposne>()) {
            /* static classes within the structure, task, scope. */
            LongRunningTaskIntrrupt expTask = new LongRunningTaskIntrrupt("Wheather-1", 3, "32", true);
            LongRunningTaskIntrrupt hotTask = new LongRunningTaskIntrrupt("Weather-2", 10, "42", true);

            //Start running task in parallel
            var expSubTask = scope.fork(expTask);
            var hotSubTask = scope.fork(hotTask);


            //handle child task result
            Subtask.State expState = expSubTask.state();
            Subtask.State hotState = hotSubTask.state();

            //wait till first child class success . send cancellation to all other child task
            //on fail wait for other thread to succeed, if both failed , return exception
            scope.join();

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

            LongRunningTaskIntrrupt.TaskResposne result = scope.result(t->new Exception(t)); //throw application
            //exception when interrupted
            System.out.println(result);

        }
    }

}
