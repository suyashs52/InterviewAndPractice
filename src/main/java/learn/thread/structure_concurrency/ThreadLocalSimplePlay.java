package learn.thread.structure_concurrency;

public class ThreadLocalSimplePlay {
    public static final ThreadLocal<User> user = new ThreadLocal<User>();
// handle method of the user handler was able to access a thread local variable called user.
    //all printed by single thread
    public static void main(String[] args) {
        print("User => "+user.get()); //nothing set , so null
        user.set(new User("anonymous"));
        print("User => "+user.get());
        handleUser();
    }
    private static void handleUser(){
        UserHandler handler=new UserHandler();
        handler.handle();
    }

    public static void print(String s) {

        System.out.printf("[%s] %s\n", Thread.currentThread(), s);

    }
}
