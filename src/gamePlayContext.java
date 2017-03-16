
public class gamePlayContext {
	 private gameState state;
	 public gamePlayContext(gameState state) {
	    this.state= state;
	 }
	public gamePlayContext() {
		    this.state= null;
		 }
	 public void nextState() {
	   state.nextState(this);
	 }
	 public int playState(){
		 return state.playState(this);
	 }
	 public void setState(gameState state) {
	   this.state = state;
	 }
	 public gameState getState() {
	   return state;
	 }
}
