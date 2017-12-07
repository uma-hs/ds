package thread;

/**
 * Created by umamaheshwar on 28/11/2017.
 */
public class TestThreadLocal {

    public static void main(String [] args) {
       new Thread(()->{
           ThreadLocalContainer.setContext("A and B are 1,2");
           StaticMethodClass.add(1,2);
       }).start();

        new Thread(()->{
            ThreadLocalContainer.setContext("A and B are 2,2");
            StaticMethodClass.add(2,2);
        }).start();

    }
}
