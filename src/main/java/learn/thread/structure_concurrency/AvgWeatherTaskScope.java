package learn.thread.structure_concurrency;

import learn.thread.structure_concurrency.LongRunningTaskIntrrupt.TaskResposne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.StructuredTaskScope;

public class AvgWeatherTaskScope extends StructuredTaskScope<TaskResposne> {

    private final List<Subtask<? extends TaskResposne>> successSubTasks = Collections.synchronizedList(new ArrayList<>());


    //when a child task completes successfully or fails, it's going to call the handle complete
    //And since multiple threads are going to use the same list, we have to use a synchronized list.
    @Override
    protected void handleComplete(Subtask<? extends TaskResposne> subtask) {
        if (subtask.state() == Subtask.State.SUCCESS) {
            add(subtask);
        }
    }


    private void add(Subtask<? extends TaskResposne> subtask) {
        int numSuccessful = 0;
        synchronized (successSubTasks) {
            successSubTasks.add(subtask);
            numSuccessful = successSubTasks.size();
        }
        if (numSuccessful == 2) shutdown(); //Shutdown method will send the cancellation request to the remaining tasks.
        //Remember the parent thread was waiting on the join and that's going to wake up.
//And the shutdown is actually being called by a child thread.
//It's the child thread which calls back on the handle complete and consequently it is the child thread /which will call the shutdown method.
//But as a result of that, the parent thread will wake up.

    }

    @Override
    public AvgWeatherTaskScope join() throws InterruptedException {
        super.join(); //if error , all task intrrupted, 2 complete 3 interrupted
        return this;
    }


    public TaskResposne response() {
        super.ensureOwnerAndJoined();
        if (successSubTasks.size() != 2) {
            throw new RuntimeException("2 Subtask must be successful !");
        }

        TaskResposne r1 = successSubTasks.get(0).get();
        TaskResposne r2 = successSubTasks.get(1).get();

        Integer temp1 = Integer.valueOf(r1.response());
        Integer temp2 = Integer.valueOf(r1.response());
        return new TaskResposne("Weather", (temp2 + temp1) / 2 + "", (r1.timeTaken() + r2.timeTaken()) / 2);
    }

    public static void main(String[] args) throws InterruptedException {

        try (AvgWeatherTaskScope scope = new AvgWeatherTaskScope()) {

            var w1Task = new LongRunningTaskIntrrupt("Whether 1", 3, "30", false);
            var w2Task = new LongRunningTaskIntrrupt("Whether 2", 4, "32", true);
            var w3Task = new LongRunningTaskIntrrupt("Whether 3", 5, "34", false);
            var w4Task = new LongRunningTaskIntrrupt("Whether 4", 6, "36", false);
            var w5Task = new LongRunningTaskIntrrupt("Whether 5", 8, "30", false);

            //subtask in parallel
            Subtask<LongRunningTaskIntrrupt.TaskResposne> w1SubTask = scope.fork(w1Task);
            Subtask<LongRunningTaskIntrrupt.TaskResposne> w2SubTask = scope.fork(w2Task);
            Subtask<LongRunningTaskIntrrupt.TaskResposne> w3SubTask = scope.fork(w3Task);
            Subtask<LongRunningTaskIntrrupt.TaskResposne> w4SubTask = scope.fork(w4Task);
            Subtask<LongRunningTaskIntrrupt.TaskResposne> w5SubTask = scope.fork(w5Task);

            //wait for 2 task to complete
            scope.join();

            //return the avg weather
            LongRunningTaskIntrrupt.TaskResposne resposne = scope.response();

            System.out.println(resposne);

        }

    }
}
