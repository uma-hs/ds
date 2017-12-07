package thread;

/**
 * Created by umamaheshwar on 28/11/2017.
 */
public class DaemonThreadTest {

    public static void main(String [] args) throws InterruptedException {
        Thread t = new Thread(()->{
            for(int i=0;i<999;i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //Dies after 1 sec if set to true as main thread dies.
        t.setDaemon(false);
        t.start();
        Thread.sleep(1000);
    }
}
