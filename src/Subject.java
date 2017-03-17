/**
 * Created by Robert Hamsch on 17.03.2017.
 */
public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}
