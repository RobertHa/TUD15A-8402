public class gameOver implements gameState{
public void nextState(gamePlayContext context){
	context.setState(new gameNoStart()); 
	System.out.println("state: Press to start!");
 }
public int playState(gamePlayContext context){
	 return 2;
}
}
