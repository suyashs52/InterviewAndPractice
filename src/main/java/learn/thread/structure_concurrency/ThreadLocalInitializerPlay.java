package learn.thread.structure_concurrency;

public class ThreadLocalInitializerPlay {
    public static final ThreadLocal<User> user = ThreadLocal.withInitial(() -> new User("anonymous"));

    public static void main(String[] args) throws InterruptedException {
        print("User => " + user.get()); //nothing set , so anonymous
        user.set(new User("main"));
        print("Modified User => " + user.get());

        Thread thread = Thread.ofVirtual().start(() -> {
            Thread.currentThread().setName("bob-thread"); //executed by bob thread not main thread,
            print("User => " + user.get()); //anonymous

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
