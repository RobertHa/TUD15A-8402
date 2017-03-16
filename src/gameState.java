
public interface GameState {
	public int getCurrentState();
	public void nextState(GameplayContext context);
	public int playState(GameplayContext context);
	public int action(GameplayContext context);
}

