import java.util.Arrays;
import java.util.Stack;


public class gameLogic {
	int sizeMatrix;
	int[][] matrix;
	boolean gameStart;
	boolean gameOver;
	int score;
	int step;
	enum direction {left,right,up,down};
	
	//construction
	gameLogic(int size){
		gameStart=true;
		gameOver=false;
		step=1;
		sizeMatrix=size;
		matrix=new int[size][size];
		for (int i=0;i<size;i++){
			for (int j=0;j<size;j++)
				matrix[i][j]=0;
		}
		matrix[0][0]=matrix[0][1]=2;
		score=0;
		
	}
	
	void setMatrix(int[][] m){
		matrix=m.clone();
	}
	
	
	//will be used for simplifying swipe 
	
	public void trans(){
		int[][] M=new int[sizeMatrix][sizeMatrix];
		for (int i=0;i<sizeMatrix;i++)
			for (int j=0;j<sizeMatrix;j++)
				M[i][j]=matrix[j][i];
		matrix=M.clone();
	}
	
	public void l2r(){
		int[][] M=new int[sizeMatrix][sizeMatrix];
		for (int i=0;i<sizeMatrix;i++)
			for (int j=0;j<sizeMatrix;j++)
				M[i][j]=matrix[i][sizeMatrix-j-1];
		matrix=M.clone();
	}
	

	
	//four actions
	

	
	public boolean swipe(direction d){
		int[][] M=new int[sizeMatrix][sizeMatrix];
		int[] zeroNum=new int[sizeMatrix];
		int i,j,k;
		boolean merged,changed=false;
		Stack<Integer> S = new Stack<Integer>(); 
		if (d==direction.left){
			for (i=0;i<sizeMatrix;i++){
				S.clear();
				zeroNum[i]=sizeMatrix;//record the number of zeros in each line
				for (j=0;j<sizeMatrix;j++){
					if (matrix[i][sizeMatrix-j-1]!=0){					
						S.push(matrix[i][sizeMatrix-j-1]);
					}					
				}
				k=0;
				merged=false;
				if (!S.empty()){
					M[i][k]=S.pop();
					zeroNum[i]--;
				}
				
				
				while (!S.empty()){
					if (S.peek()==M[i][k] && merged==false)
					{	
						M[i][k]=S.pop()*2;
						merged=true;
					}
					else
					{
						k++;
						M[i][k]=S.pop();
						zeroNum[i]--;
						merged=false;
					}
				}
				
				if (!Arrays.equals(matrix[i], M[i])){
					changed=true;
				}
			}
			
			if (changed==false)
			{
				System.out.print("Same!\n");
				if (isFull()){
					gameOver=true;//game over
				}
			}
			else
			{
				matrix=M.clone();
				generateNewBlock(zeroNum);// all direction here is left
			}
		}
		
		
		if (d==direction.right){
			l2r();
			changed=swipe(direction.left);
			l2r();
		}
		
		if (d==direction.up){
			trans();
			changed=swipe(direction.left);
			trans();
		}
		if (d==direction.down){
			trans();
			l2r();
			changed=swipe(direction.left);
			l2r();
			trans();
		}
		
		return changed;
		
	}
	
		
	//see if full
	public boolean isFull(){
		for (int i=0;i<sizeMatrix;i++){
			for (int j=0;j<sizeMatrix;j++)
				if (matrix[i][j]==0){
					return false;
				}
		}
		return true;
	}
	

	

	public void generateNewBlock(int[] znum){
		int numZero=0;
		int i;
		for (i=0;i<sizeMatrix;i++){
			numZero=numZero+znum[i];
//			System.out.print(znum[i]);
		}
//		System.out.print('\t');
//		System.out.print(numZero);
//		System.out.print('\t');
		int newPos=(int)(Math.random()*numZero);
//		System.out.print(newPos);
//		System.out.print('\t');
		i=0;
		while (newPos>=znum[i]){
			newPos=newPos-znum[i++];
		}
		
		if (Math.random()>0.3){
			matrix[i][sizeMatrix-newPos-1]=2;//2 or 4
		}
		else{
			matrix[i][sizeMatrix-newPos-1]=4;
		}
					
		
	}
	
	//restart
	void restart(int size){
		gameStart=true;
		gameOver=false;
		step=1;
		sizeMatrix=size;
		matrix=new int[size][size];
		for (int i=0;i<size;i++){
			for (int j=0;j<size;j++)
				matrix[i][j]=0;
		}
		matrix[0][0]=matrix[0][1]=2;
		score=0;	
	}
	
	
	
	//for testing
	public void show(){
		System.out.format("Step%d:\n\n",step);
		for (int i=0;i<sizeMatrix;i++){
			for (int j=0;j<sizeMatrix;j++)
				System.out.format("%d\t",matrix[i][j]);
			System.out.println('\n');
		}
		step=step+1;
		System.out.println('\n');
	}
	
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
}
