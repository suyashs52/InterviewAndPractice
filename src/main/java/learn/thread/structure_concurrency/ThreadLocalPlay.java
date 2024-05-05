package learn.thread.structure_concurrency;

public class ThreadLocalPlay {
    public static final ThreadLocal<User> user = new ThreadLocal<User>();

    // handle method of the user handler was able to access a thread local variable called user.
    //all printed by single thread
    public static void main(String[] args) throws InterruptedException {
        print("User => " + user.get()); //nothing set , so null
        user.set(new User("main"));
        print("Modified User => " + user.get());

        Thread thread = Thread.ofVirtual().start(() -> {
            Thread.currentThread().setName("bob-thread"); //executed by bob thread not main thread,
            print("User => " + user.get()); //null

            user.set(new User("bob"));
            print("Modified User => " + user.get()); //bob , main name will not print


        });
        thread.join(); //main thread waiting for completion of other thread.
        print(" User => " + user.get()); //main thread , Main will print

        handleUser();
    }

    private static void handleUser() {
        UserHandler handler = new UserHandler();
        handler.handle();
    }

    public static void print(String s) {

        System.out.printf("[%s] %s\n", Thread.currentThread(), s);

    }
}
