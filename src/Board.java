import java.util.Arrays;

/**
 * Created by Robert Hamsch on 16.03.2017.
 */
public class Board {
	int size;
	int[][] board;
	int roundScore;

	Board(int size) {
		this.size = size;
		roundScore = 0;
		board = new int[size][size];

		// this is needed for the generation of the first number
		int[] dummy = new int[size];
		Arrays.fill(dummy, size);

		GameLogic.generateNewBlock(dummy, this);

	}
}
