public class gameOver implements GameState {
	public static final int currentState = 2;
	public int getCurrentState() {
		return currentState;
	}
public void nextState(GameplayContext context){
	context.setState(new GameNoStart());
	System.out.println("State: Press to start!");
 }
public int playState(GameplayContext context){
	 return 2;
}

	@Override
	public int action(GameplayContext context) {

	}
}
