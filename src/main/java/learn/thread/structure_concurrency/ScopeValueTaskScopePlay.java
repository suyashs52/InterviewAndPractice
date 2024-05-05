package learn.thread.structure_concurrency;

import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.ThreadFactory;

import static learn.thread.structure_concurrency.ThreadLocalInitializerPlay.print;

public class ScopeValueTaskScopePlay {
    private static final ScopedValue<User> user = ScopedValue.newInstance();

    public static void main(String[] args) throws Exception {
        print("user is bound =>" + user.isBound()); //false, user.get() will give the exception

        User bob = new User("bob");

        ScopedValue.where(user, bob).run(ScopeValueTaskScopePlay::invokeTaskScope);


        print("User is bound =>" + user.isBound()); //false
    }

    private static void invokeTaskScope() {
        try {


            print("User is bound =>" + user.isBound()); //true

            ThreadFactory threadFactory = Thread.ofVirtual().name("name - ", 0).factory();
            try (StructuredTaskScope<String> scope = new StructuredTaskScope<>("test-scope", threadFactory)) {
                //above line will ensure that all threads which are forked from inside will die before the block is exited.
                scope.fork(() -> {
                    //to fork a single task which will create a new virtual thread and run the submitted code
                    //in this separate thread.
                    User reqUser = user.orElse(new User("anonymous"));
                    print("Invoke task scope is bound =>" + reqUser); //bob, copied from parent, inside parent thread
                    // we are using structured task scope.
                    //many sub task invoked
                    reqUser.setId("bob1"); //Even though the scope variable itself is immutable, the value object may be mutable.
                    //If you don't need the value to be mutable, then a good design choice is to use a Java record.
                    return "done";
                });
                scope.join();
            }
            User reqUser = user.orElse(new User("anonymous1"));
            print("After try Invoke task scope is bound =>" + reqUser); //bob1


        } catch (Exception ex) {

        }
    }


}
