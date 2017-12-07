package patterns.observer;

/**
 * Created by umamaheshwar on 28/11/2017.
 */
public class SomeOtherObserver implements Observer {
    @Override
    public void notify(String update) {
        System.out.println("SomeOtherObserver - Got an update from Weather forecaster : "+update);
    }
}
