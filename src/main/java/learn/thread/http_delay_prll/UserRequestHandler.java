package learn.thread.http_delay_prll;

import java.util.Arrays;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class UserRequestHandler implements Callable {


    @Override
    public String call() throws Exception {
//        sequentialCal();
//        concurrentCallWithFuture();
//        concurrentFunctionalCallWithFuture();

        //db call, rest call are in parallel, they are combine, then apply called on completable future,
        //make seprate call to exter
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            String result = CompletableFuture.supplyAsync(this::dbCall, executor)
                    .thenCombine(CompletableFuture.supplyAsync(this::restCall, executor)
                            , (resultDb, resultRest) -> {
                                return "[{" + resultDb + "},{" + resultRest + "}]";
                            })//But once we combine these two.  I want to be able to process the results
                    .thenApply(next -> {
                        //both db call and rest call have completed
                        String r = externalCall();
                        return "[{" + next + "},---<>,{" + r + "}]";

                    })// the input is the return value from the previous  future get that is concatenation of 2
                    .join();//return the result when complete, it blocking get and join block the thread
            //but virtual thread this is no issue

            System.out.println(result);
            return result;
        }

    }

    private String concurrentFunctionalCallWithFuture() throws InterruptedException {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            String result = executor.invokeAll(Arrays.asList(this::dbCall, this::restCall)) //callable return future
                    .stream()
                    .map(objectFuture -> {
                        try {
                            return (String) objectFuture.get();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        } catch (ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .collect(Collectors.joining(","));
            System.out.println(result);
            return "[{" + result + "}]";
        }
    }

    private String concurrentCallWithFuture() throws InterruptedException, ExecutionException {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            long start = System.currentTimeMillis();

            Future<String> dbVal = executor.submit(this::dbCall);
            Future<String> restVal = executor.submit(this::restCall);


            String result = String.format("[%s,%s]", dbVal.get(), restVal.get());

            long end = System.currentTimeMillis();
            System.out.println("time = {" + (end - start) + "}");
            System.out.println(result); //time is 5.6sec
            return result;

        }
    }

    private String sequentialCal() {
        long start = System.currentTimeMillis();
        String resultDb = dbCall(); //2 sec
        String resultRest = restCall(); //5 sec


        String result = String.format("[%s,%s]", resultDb, resultRest);

        long end = System.currentTimeMillis();
        System.out.println("time = {" + (end - start) + "}");
        System.out.println(result);
        return result;
    }

    private String dbCall() {
        //  System.out.println(STR."Data :\{Thread.currentThread()}");
        NetworkCaller networkCaller = new NetworkCaller("data");
        try {
            return networkCaller.makeCall(2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String restCall() {
        //System.out.println(STR."Rest \{Thread.currentThread()}");
        NetworkCaller networkCaller = new NetworkCaller("rest");
        try {
            return networkCaller.makeCall(5);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String externalCall() {

        NetworkCaller networkCaller = new NetworkCaller("external");
        try {
            return networkCaller.makeCall(4);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
