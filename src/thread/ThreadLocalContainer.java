package thread;

/**
 * Created by umamaheshwar on 28/11/2017.
 */
public class ThreadLocalContainer {

    //    private static final ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void setContext(String val) {
        threadLocal.set(val);
    }

    public static String getContext() {
        return threadLocal.get();
    }

    public static void clear() {
        threadLocal.remove();
    }
}
