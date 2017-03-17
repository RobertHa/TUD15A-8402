import java.awt.event.KeyEvent;

public class GameOver implements GameState {
	public static final int currentState = 2;
	public int getCurrentState() {
		return currentState;
	}
public void nextState(Game game){
	game.context.setState(new Menu());
	System.out.println("State: Press to start!");
 }
	@Override
	public void action(Game game) {
		if(game.key== KeyEvent.VK_SPACE){
            game.board = new Board(game.currentSize);
            this.nextState(game);
        }
	}
}
