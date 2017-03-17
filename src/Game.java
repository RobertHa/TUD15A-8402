/**
 * Created by Robert Hamsch on 16.03.2017.
 */
public class Game implements Subject{
    GameplayContext context;
    Display display;
    Board board;
    int currentSize;
    Score score;
    int key;


    Game(int size){
        this.context = new GameplayContext(new Menu());//TODO more here
        this.score = new Score(this);
        currentSize = size;
    }


    public static void main(String[] a) {
        int size=4;
        Game game = new Game(size);
        game.display = new Display("Test", 300, 300, game);
        game.display.setVisible(true);
    }

    @Override
    public void registerObserver(Observer observer) {
        
    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObserver() {

    }
}
