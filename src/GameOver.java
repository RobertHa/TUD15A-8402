import java.awt.event.KeyEvent;

public class GameOver implements GameState {
	public static final int currentState = 2;

    public int getCurrentState() {
		return currentState;
	}

    public void nextState(Game game){
	    game.context.setState(new Menu());
    }
	@Override
	public void action(Game game) {

        //there is only a change if the Key matches
		if(game.key== KeyEvent.VK_SPACE){
            game.removeObserver(game.observers.get(0));
            this.nextState(game);
        }
	}
}
