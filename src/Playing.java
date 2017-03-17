import java.awt.event.KeyEvent;

public class Playing implements GameState {
    static final int currentState = 1;
    public int getCurrentState() {
        return currentState;
    }
 public void nextState(Game game){
	game.context.setState(new GameOver());
	System.out.println("state: Game Over! Press SPACE to start!");
 }

    @Override
    public void action(Game game) {
        switch (game.key) {
            case KeyEvent.VK_UP:
                GameLogic.swipe(GameLogic.direction.up,game.board,game);
                break;
            case KeyEvent.VK_LEFT:
                GameLogic.swipe(GameLogic.direction.left,game.board,game);
                break;
            case KeyEvent.VK_DOWN:
                GameLogic.swipe(GameLogic.direction.down,game.board,game);
                break;
            case KeyEvent.VK_RIGHT:
                GameLogic.swipe(GameLogic.direction.right,game.board,game);
                break;
        }
    }
}
