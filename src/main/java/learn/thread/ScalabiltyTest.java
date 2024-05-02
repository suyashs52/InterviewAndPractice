package learn.thread;

public class ScalabiltyTest {

    private static void handleUserRequest() {
        System.out.println("Starting Thread: " + Thread.currentThread());
        try {
            Thread.sleep(10000); //10 sec sleep
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ending Thread: " + Thread.currentThread());

    }

    public static void mainThreadTest() {
        System.out.println("Starting Main ");  //main thead ended soon , but jvm wait for all non-daemon thread to close
        //so this program will run after 10 sec and then end
        new Thread(() -> handleUserRequest()).start();

        System.out.println("Ending Main");
    }


    public static void main(String[] args) {
        System.out.println("Starting Main ");
    //give vm argument by clicking on run configuration> VM option > -Xss1M -Xmx1G  stack size 1 mb, max heap size 1 gb
    //when you change n=10000, Failed to start the native thread for java.lang.Thread "Thread-4066"
        //pthread_create failed (EAGAIN) for attributes: stacksize: 1024k, guardsize: 16k, detached
        //possibly out of memory or process/resource limits reached
        //but all other 4000 threads will start and ended after execution
        //also based on CPU core , ex for 2 core , 8gb ram, max thread can be 2000
        //so this system can't support more then 4000 concurrent user in best case, in reality very less then this
        //cd bin ,      //        //java -Xmx1G maxthreads.MainJacket > out-pthread-1mil.log
        //print the log into file , run outside of intellij

        int n=10000;//1000;//10;
        for (int i = 0; i <n; i++) { //create n thread, order of thread run the application not in syn
            //any thread if find cpu then run the code
            new Thread(() -> handleUserRequest()).start();
        }

        System.out.println("Ending Main");
    }
}
