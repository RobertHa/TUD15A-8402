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
		game.board = new Board(game.currentSize);
        game.display.repaint();
        this.nextState(game);
	}
}
