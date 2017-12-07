package patterns.observer;

/**
 * Created by umamaheshwar on 28/11/2017.
 */
public interface Observable {
    public void notifyObservers();
    public void addObserver(Observer observer);
}
