import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Grid extends Canvas{

	      gameLogic M;
		  int width, height;

		  Grid(int w, int h,  gameLogic M) {
		    setSize(width = w, height = h);
		    this.M = M;
		  }

		  public void paint(Graphics g) {
		    width = getSize().width;
		    height = getSize().height;

			int rows = M.sizeMatrix;
			  int cols = M.sizeMatrix;
		    // draw the rows
		    int rowHt = height / (rows);
		    for (int i = 0; i < rows; i++)
		      g.drawLine(0, i * rowHt, width, i * rowHt);

		    // draw the columns
		    int rowWid = width / (cols);
		    for (int i = 0; i < cols; i++)
		      g.drawLine(i * rowWid, 0, i * rowWid, height);
		    
		    // draw the numbers
		    for (int i=0; i< rows; i++){
		    	for (int j=0; j< cols; j++){
		    		if (M.matrix[i][j] != 0)
		    		g.drawString(Integer.toString(M.matrix[i][j]), (j+ 1) * rowWid - (rowWid / 2), (i+1) * rowHt - (rowHt /2));
		    	}
		    }
		  }
		  
		  public void update(){
			  
		  }
		
}
