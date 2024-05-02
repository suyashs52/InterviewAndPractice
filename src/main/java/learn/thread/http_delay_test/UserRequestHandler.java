package learn.thread.http_delay_test;

import java.time.Duration;
import java.util.concurrent.Callable;

public class UserRequestHandler implements Callable {


    @Override
    public String call() throws Exception {
        String resultDb = dbCall();
        String resultRest = restCall();

        Thread.sleep(Duration.ofMinutes(10)); //sleep for 10 mins to check jconsole
        String result = String.format("[%s,%s]", resultDb, resultRest);

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
}
