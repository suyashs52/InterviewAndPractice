package learn.thread.structure_concurrency;

public class User {
    String id;

    public User(String name) {
        this.id = name;
    }

    public String id() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s]", super.toString(), this.id);
    }
}
