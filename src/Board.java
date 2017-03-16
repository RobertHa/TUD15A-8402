import java.util.Arrays;

/**
 * Created by Robert Hamsch on 16.03.2017.
 */
public class Board {
    int size;
    int [][] board;
    int score;
    Board(int size){
        this.size = size;
        score = 0;
        board = new int[size][size];
        int [] dummy = new int[size];
        Arrays.fill(dummy,size);
        GameLogic.generateNewBlock(dummy,this);
    }
}
