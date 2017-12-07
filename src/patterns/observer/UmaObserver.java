package patterns.observer;

/**
 * Created by umamaheshwar on 28/11/2017.
 */
public class UmaObserver implements Observer {
    @Override
    public void notify(String update) {
        System.out.println("UMA - Got an update from Weather forecaster : "+update);
    }
}
