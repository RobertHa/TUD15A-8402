public class gamePlaying implements GameState {
    static final int currentState = 1;
    public int getCurrentState() {
        return currentState;
    }
 public void nextState(GameplayContext context){
	context.setState(new gameOver()); 
	System.out.println("state: Game Over! Press SPACE to start!");
 }
 public int playState(GameplayContext context){
	 return 1;
 }
}
