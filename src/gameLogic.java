import java.util.Arrays;

public class gameLogic {



	enum direction {left,right,up,down};//4 directions
	private static GameplayContext context;

	

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

	// four actions

	public static boolean swipe(direction d, Board board) {
		int[][] M = new int[board.size][board.size];
		int[] zeroNum = new int[board.size];
		int i, j, k;
		boolean changed = false;
		
		//swipe to start
		if (context.playState()==0){
			context.nextState();
		}
		
		if (d == direction.left) {
			for (i = 0; i < board.size; i++) {

				zeroNum[i] = board.size;// record the number of zeros in each
										// line

				k = 0;
				for (j = 0; j < board.size; j++) {
					if (board.board[i][j] != 0) {
						if (M[i][k] == 0) {
							M[i][k] = board.board[i][j];
							zeroNum[i]--;
						} else if (M[i][k] == board.board[i][j]) {
							M[i][k] = board.board[i][j] * 2;
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
				//System.out.print("Same!\n");
				if (isFull(board)) {
					// full& not movable leads to gameover
					if (!isMovable(board)) {
						calcScore(board);
						//playing to game over
						context.nextState();
					}
				}
			} else {
				board.board = M.clone();
				generateNewBlock(zeroNum,board);// all direction here is left
			}
		}

		if (d == direction.right) {
			l2r(board);
			changed = swipe(direction.left, board);
			l2r(board);
		}

		if (d == direction.up) {
			trans(board);
			changed = swipe(direction.left,board);
			trans(board);
		}
		if (d == direction.down) {
			trans(board);
			l2r(board);
			changed = swipe(direction.left,board);
			l2r(board);
			trans(board);
		}

		return changed;

	}

	// calculates highest tile when you are gameover
	public static void calcScore(Board board) {
        int score = 0;
		for (int i = 0; i < board.size; i++) {
			for (int j = 0; j < board.size; j++) {
				score = Math.max(score, board.board[i][j]);
			}
		}
        board.score = score;
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
		// if (Math.random()>0.3){
		board.board[i][board.size - newPos - 1] = 2;// 2 or 4
		// }
		// else{
		// matrix[i][sizeMatrix-newPos-1]=4;
		// }
        return board;
	}

	// restart
	void restart(int size) {

		//System.out.println("Press arrow keys to play the game!");
		context.nextState();
		
		step = 1;
		sizeMatrix = size;
		matrix = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				matrix[i][j] = 0;
		}
		matrix[0][0] = matrix[0][1] = 2;
		score = 0;
	}

	// for testing
	/*public void show() {
		System.out.format("Step%d:\n\n", step);
		for (int i = 0; i < sizeMatrix; i++) {
			for (int j = 0; j < sizeMatrix; j++)
				System.out.format("%d\t", matrix[i][j]);
			System.out.println('\n');
		}
		step = step + 1;
		System.out.println('\n');
	}
	*/
	public int playState(){
		return context.playState();
	}

	/*
	public static void main(String[] args)
	{
		int size=4;
		gameLogic M=new gameLogic(size);
		System.out.println("Origine: \n");
		M.show();
		while (M.gameOver==false){
			int tmp=(int)(Math.random()*4);
			switch(tmp){
			case 0:
				System.out.println("swipe up: \n");
				M.swipe(direction.up);
				M.show();
				break;
			case 1:
				System.out.println("swipe left: \n");
				M.swipe(direction.left);
				M.show();
				break;
			case 2:
				System.out.println("swipe down: \n");
				M.swipe(direction.down);
				M.show();
				break;
			default:
				System.out.println("swipe right: \n");
				M.swipe(direction.right);
				M.show();
				break;
			}
		}

	}
	*/

}
