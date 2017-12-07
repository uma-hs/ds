package test;

/**
 * Created by umamaheshwar on 30/11/2017.
 */
public abstract class Base<T> {
    int status;
    T message;

    int getStatus() {
        return status;
    }

    public abstract T getMessage();
}
