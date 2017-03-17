/**
 * Created by Robert Hamsch on 17.03.2017.
 */
public class Score implements Observer {
    Game game;
    int score;

    public Score(Game game){
        this.game = game;
        this.score = 0;
    }

    public void update(){
        score+=game.board.roundScore;
    }
}
