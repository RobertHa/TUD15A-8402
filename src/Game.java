import java.util.ArrayList;

/**
 * Created by Robert Hamsch on 16.03.2017.
 */
public class Game implements Subject{
    GameplayContext context;
    Display display;
    Board board;
    int currentSize;
    int key;
    ArrayList<Observer> observers;
    private static Game singleInstance;

    private Game(int size){
        this.context = new GameplayContext(new Menu());//TODO more here
        observers = new ArrayList<>(1);
        currentSize = size;
    }
    public static Game getInstance(int size){
        if (Game.singleInstance == null){
            singleInstance = new Game(size);
            return singleInstance;
        }
        return null;
    }

    public static void main(String[] a) {
        int size=4;
        Game game = Game.getInstance(size);
        game.display = new Display("Test", 500, 300, game);
        game.display.setVisible(true);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer obs:this.observers
             ) {
            obs.update();
        }
    }
}
