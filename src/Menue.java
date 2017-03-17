import java.awt.event.KeyEvent;

public class Menue implements GameState {
    static final int currentState = 0;


    @Override
    public int getCurrentState() {
        return currentState;
    }

    public void nextState(Game game){
	game.context.setState(new Playing());
	System.out.println("state: Game starts!");
 }
 public int playState(GameplayContext context){
	 return 0;
 }

    @Override
    public void action(Game game) {
        System.out.println("at the menue action, key is: "+(game.key==KeyEvent.VK_S?"s":"e"));
        if(game.key == KeyEvent.VK_S){
            game.board= new Board(game.currentSize);
            game.display.repaint();
            this.nextState(game);
        }
        
        if (game.key == KeyEvent.VK_E){
            System.exit(0);
        }
    }
}
