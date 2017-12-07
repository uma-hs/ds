package patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by umamaheshwar on 28/11/2017.
 */
public class WeatherBroadCast implements Observable {

    private List<Observer> observers = new ArrayList<>();

    private String currentState = "NO UPDATE";


    @Override
    public void notifyObservers() {
        observers.forEach(observer -> {
            observer.notify(currentState);
        });
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
        this.notifyObservers();
    }
}
