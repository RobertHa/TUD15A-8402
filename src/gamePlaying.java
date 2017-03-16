public class gamePlaying implements gameState{
 public void nextState(gamePlayContext context){
	context.setState(new gameOver()); 
	System.out.println("state: Game Over! Press SPACE to start!");
 }
 public int playState(gamePlayContext context){
	 return 1;
 }
}
