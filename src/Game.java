/**
 * Created by Robert Hamsch on 16.03.2017.
 */
public class Game {
    GameplayContext context;
    Display display;
    Board board;
    int currentSize;
    GameLogic.direction dir;
    int key;


    Game(int size){
        this.context = new GameplayContext(new Menu());//TODO more here
        //this.board = new Board(size);
        currentSize = size;
    }


    public static void main(String[] a) {
        int size=4;
        Game game = new Game(size);
        game.display = new Display("Test", 300, 300, game);
        game.display.setVisible(true);
    }

}
