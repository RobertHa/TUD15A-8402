
public class gameNoStart implements gameState{
 public void nextState(gamePlayContext context){
	context.setState(new gamePlaying()); 
	System.out.println("state: Game starts!");
 }
 public int playState(gamePlayContext context){
	 return 0;
 }
}
