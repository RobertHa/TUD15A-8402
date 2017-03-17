import java.util.Arrays;

public class GameLogic {



	enum direction {left,right,up,down};//4 directions

	

	// will be used for simplifying swipe
	// trans turns up/down to left/right
	// l2r turns from right to left
	private static void trans(Board board) {
		int[][] M = new int[board.size][board.size];
		for (int i = 0; i < board.size; i++)
			for (int j = 0; j < board.size; j++)
				M[i][j] = board.board[j][i];
		board.board = M.clone();
	}

	private static void l2r(Board board) {
		int[][] M = new int[board.size][board.size];
		for (int i = 0; i < board.size; i++)
			for (int j = 0; j < board.size; j++)
				M[i][j] = board.board[i][board.size - j - 1];
		board.board = M.clone();
	}


    //perform an action on the board
	public static boolean swipe(direction d, Board board,Game game) {
		int[][] M = new int[board.size][board.size];
		int[] zeroNum = new int[board.size];
		int i, j, k;
		boolean changed = false;

		
		if (d == direction.left) {
			for (i = 0; i < board.size; i++) {

				zeroNum[i] = board.size;// record the number of zeros in each line

				k = 0;
				for (j = 0; j < board.size; j++) {
					if (board.board[i][j] != 0) {
						if (M[i][k] == 0) {
							M[i][k] = board.board[i][j];
							zeroNum[i]--;
						} else if (M[i][k] == board.board[i][j]) {
							M[i][k] = board.board[i][j] * 2;
                            game.board.roundScore += M[i][k]*10; //adding up the score for this move
							k++;
						} else {
							k++;
							M[i][k] = board.board[i][j];
							zeroNum[i]--;
						}
					}
				}

				// see if there is any change
				if (!Arrays.equals(board.board[i], M[i])) {
					changed = true;
				}
			}

			if (changed == false) {
				if (isFull(board)) {
					// full& not movable leads to gameover
					if (!isMovable(board)) {
						//playing to game over
						game.context.state.nextState(game);
					}
				}
			} else {
				board.board = M.clone();
				generateNewBlock(zeroNum,board);// all direction here is left
			}
		}

		if (d == direction.right) {
			l2r(board);
			changed = swipe(direction.left, board, game);
			l2r(board);
		}

		if (d == direction.up) {
			trans(board);
			changed = swipe(direction.left,board,game);
			trans(board);
		}
		if (d == direction.down) {
			trans(board);
			l2r(board);
			changed = swipe(direction.left,board,game);
			l2r(board);
			trans(board);
		}

		return changed;

	}


	// see if full
	private static boolean isFull(Board board) {
		for (int i = 0; i < board.size; i++) {
			for (int j = 0; j < board.size; j++)
				if (board.board[i][j] == 0) {
					return false;
				}
		}
		return true;
	}

	// see if movable
	private static boolean isMovable(Board board) {
		for (int i = 0; i < board.size; i++) {
			for (int j = 0; j < board.size - 1; j++)
				if (board.board[i][j] == board.board[i][j + 1] || board.board[j][i] == board.board[j + 1][i]) {
					return true;
				}
		}
		return false;
	}

	public static Board generateNewBlock(int[] znum, Board board) {
		int numZero = 0;
		int i;
		// first count the number
		for (i = 0; i < board.size; i++) {
			numZero = numZero + znum[i];
		}
		int newPos = (int) (Math.random() * numZero);// decide the position
		i = 0;
		while (newPos >= znum[i]) {
			newPos = newPos - znum[i++];
		}
		// generate a new block
		board.board[i][board.size - newPos - 1] = 2;// 2 or 4
        return board;
	}




}
