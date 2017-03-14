import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Grid extends Canvas{
	
		  int width, height;

		  int rows;

		  int cols;
		  
		  int[][] matrix ;

		  Grid(int w, int h, int r, int c, int[][] m) {
		    setSize(width = w, height = h);
		    rows = r;
		    cols = c;
		    matrix = m;
		  }

		  public void paint(Graphics g) {
		    width = getSize().width;
		    height = getSize().height;

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
		    		if (matrix[i][j] != 0)
		    		g.drawString(Integer.toString(matrix[i][j]), (i+ 1) * rowWid - (rowWid / 2), (j+1) * rowHt - (rowHt /2));
		    	}
		    }
		  }
		  
		  public void update(){
			  
		  }
		
}
