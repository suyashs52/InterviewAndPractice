package learn.thread.basic;

public class EmpSynchronized {
    //If we created an object
    //three different threads attempted to execute each method of the object
    //only one will get access, and the other two will block
    private String name;

    // method is synchronize on 'this' object
    public synchronized void setName(String name) {
        this.name = name;
    }

    // also synchronized on the same object
    public synchronized void resetName() {

        this.name = "";
    }

    // equivalent of adding synchronized in method
    // definition
    public String getName() {
        synchronized (this) {
            return this.name;
        }
    }
}
