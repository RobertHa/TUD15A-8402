import java.awt.event.KeyEvent;

public class Menu implements GameState {
    static final int currentState = 0;


    @Override
    public int getCurrentState() {
        return currentState;
    }

    public void nextState(Game game){
	game.context.setState(new Playing());
	System.out.println("state: Game starts!");
 }
 public int playState(GameplayContext context){
	 return 0;
 }

    @Override
    public void action(Game game) {

        if(game.key == KeyEvent.VK_S){
            game.board= new Board(game.currentSize);
            Observer score = new Score(game);
            game.registerObserver(score);
            this.nextState(game);
        }
        
        if (game.key == KeyEvent.VK_E){
            System.exit(0);
        }
    }
}
