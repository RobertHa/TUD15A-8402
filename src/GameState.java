
public interface GameState {
	public int getCurrentState();

	public void nextState(Game game);

	public void action(Game game);
}
