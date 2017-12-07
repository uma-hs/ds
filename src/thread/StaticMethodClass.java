package thread;

/**
 * Created by umamaheshwar on 28/11/2017.
 */
public class StaticMethodClass {

    static int add(int a, int b) {
        System.out.println("Inside StaticMathodClass "+ThreadLocalContainer.getContext());
        new Thread(()->{
            System.out.println("New thread from static method add() "+ThreadLocalContainer.getContext());
        }).start();

        return a+b;
    }
}
