package learn.thread.structure_concurrency;

import static learn.thread.structure_concurrency.ThreadLocalInitializerPlay.print;

public class ScopeValuePlay {
    //scoped value version of a similar class used before to explain thread locals.
    private static final ScopedValue<User> user = ScopedValue.newInstance();

    public static void main(String[] args) throws Exception {
        print("user is bound =>" + user.isBound()); //false, user.get() will give the exception

        User bob = new User("bob");
//We are not calling this method directly why we would like to make the scoped value.
//]//User available to this method as user bob ,Value user is again unbound and it will be cleaned up automatically.
// all ,  the fact that the handle method of the scoped user handler was
//able to access a scoped value variable called user.,implicit parameter to all of these methods within the
//dynamic scope.,can't access after this method.
        boolean result = ScopedValue.callWhere(user, bob, ScopeValuePlay::handleUser);

        print("result => " + result); //true
        print("User is bound =>" + user.isBound()); //false , This line is no longer in the dynamic scope of the user binding, so it will print false.
    }

    private static boolean handleUser() {
        ScopeValueHandler handler = new ScopeValueHandler();
        return handler.handle();
    }


    static class ScopeValueHandler {


        boolean handle() {
            boolean bound = ScopeValuePlay.user.isBound();
            print("handle : User  =>" + user.get()); // bob

//runnable call
            //The main difference between runnable and callable is that runnable will always return void and will
            //not throw any exception, whereas the callable will return a particular object and may also throw an
            //exception.
            ScopedValue.runWhere(user, new User("anonymous"), ScopeValueRebindPlay::callAsAnonymous);

            print("handle : User is bound =>" + bound); //bob


            return bound;
        }

    }

    static class ScopeValueRebindPlay {
        static void callAsAnonymous() {
            print("handle : User is anonymous  =>" + user.get()); //anonymous
            //if the method call as anonymous happens to call another method?
            //That new method will also see user as anonymous because it's in the dynamic scope of the call as anonymous
//The moment this new dynamic scope ends, the old binding would take into effect.
        }
    }

}
