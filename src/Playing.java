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
        System.out.println("Direction is "+game.dir);
        gameLogic.swipe(game.dir,game.board,game);
        game.display.repaint();
    }
}
