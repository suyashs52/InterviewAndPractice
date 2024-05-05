package learn.thread.structure_concurrency;

import static learn.thread.structure_concurrency.ThreadLocalInitializerPlay.print;

public class ScopeValueThreadPlay {
    private static final ScopedValue<User> user = ScopedValue.newInstance();

    public static void main(String[] args) throws Exception {
        print("user is bound =>" + user.isBound()); //false, user.get() will give the exception

        User bob = new User("bob");

        ScopedValue.where(user, bob).run(ScopeValueThreadPlay::invokeThread);


        print("User is bound =>" + user.isBound()); //false
    }

    private static void invokeThread() {
        try {

            print("User is bound =>" + user.isBound()); //true

            User reqUser = user.get();

            String id = reqUser.id + " -thread";
            Thread thr = Thread.ofVirtual().name(id).start(() -> {
                print("User is bound =>" + user.isBound()); //false
                User reqsetedUser = user.orElse(new User("anonymous"));

                print("Invokde thread User is bound =>" + reqsetedUser);  //annonymous

            });
            thr.join();
        } catch (Exception ex) {

        }
    }


}
