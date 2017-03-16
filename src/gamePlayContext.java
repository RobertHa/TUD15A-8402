
public class GameplayContext {
	 GameState state;
	 public GameplayContext(GameState state) {
	    this.state= state;
	 }
	public GameplayContext() {
		    this.state= null;
		 }
	 public void nextState() {
	   state.nextState(this);
	 }
	 public int playState(){
		 return state.playState(this);
	 }
	 public void setState(GameState state) {
	   this.state = state;
	 }
	 public GameState getState() {
	   return state;
	 }
}
