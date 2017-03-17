
public class GameplayContext {
	GameState state;

	public GameplayContext(GameState state) {
		this.state = state;
	}

	public void setState(GameState state) {
		this.state = state;
	}

	public GameState getState() {
		return state;
	}
}
