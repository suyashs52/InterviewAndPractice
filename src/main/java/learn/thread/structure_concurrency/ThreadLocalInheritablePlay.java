package learn.thread.structure_concurrency;

public class ThreadLocalInheritablePlay {
    public static final InheritableThreadLocal<User> user = new InheritableThreadLocal<User>() { //optional to override
        @Override
        protected User childValue(User parentValue) {
            return new User(parentValue.id + " :fromParent");
        }

        @Override
        protected User initialValue() {
            return new User("over: annonymous");
        }
    };


    public static void main(String[] args) throws InterruptedException {
        print("User => " + user.get()); //nothing set , so null
        user.set(new User("main"));
        print("Modified User => " + user.get()); //main

        Thread thread = Thread.ofVirtual().start(() -> {
            Thread.currentThread().setName("bob-thread"); //executed by bob thread not main thread,
            print("User => " + user.get()); //main not null

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
