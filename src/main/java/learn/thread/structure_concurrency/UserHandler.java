package learn.thread.structure_concurrency;

public class UserHandler {
    public void handle() {
        User user = ThreadLocalSimplePlay.user.get();
        print("handle - user => " + user);
    }

    public static void print(String m) {
        ThreadLocalSimplePlay.print(m);
    }
}
