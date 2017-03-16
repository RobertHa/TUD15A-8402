public class gameOver implements gameState{
public void nextState(gamePlayContext context){
	context.setState(new gameNoStart()); 
	System.out.println("State: Press to start!");
 }
public int playState(gamePlayContext context){
	 return 2;
}
}
