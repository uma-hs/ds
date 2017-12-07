package patterns.observer;

/**
 * Created by umamaheshwar on 28/11/2017.
 */
public class ObserverTest {

    public static void main(String args[]) throws InterruptedException {
        WeatherBroadCast weatherBroadCast = new WeatherBroadCast();
        Observer uma = new UmaObserver();
        Observer some = new SomeOtherObserver();
        weatherBroadCast.addObserver(uma);
        weatherBroadCast.addObserver(some);

        String [] updates = new String[] {
          "CYCLONE","TSUNAMI","HEAVY RAIN"
        };

        for(String update : updates) {
            weatherBroadCast.setCurrentState(update);
            Thread.sleep(1000);
        }



    }
}
