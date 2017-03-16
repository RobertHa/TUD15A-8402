
public class GameNoStart implements GameState {
    static final int currentState = 0;


    @Override
    public int getCurrentState() {
        return currentState;
    }

    public void nextState(GameplayContext context){
	context.setState(new gamePlaying()); 
	System.out.println("state: Game starts!");
 }
 public int playState(GameplayContext context){
	 return 0;
 }

    @Override
    public int action(GameplayContext context) {

    }
}
