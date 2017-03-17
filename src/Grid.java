import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Grid extends Canvas {

	Game game;
	int width, height;

	Grid(int w, int h, Game g) {
		setSize(width = w, height = h);
		this.game = g;
	}

	public void paint(Graphics g) {

		Color[] c={Color.white,Color.white, new Color(255,255,170), new Color(255,255,128), new Color(255,255,85)
				, new Color(255,255,43), new Color(255,255,0), new Color(213,213,0), new Color(170,170,0)
				, new Color(128,128,0), new Color(85,85,0), new Color(43,43,0)};
		width = getSize().width - 200;
		height = getSize().height;

		if (game.context.state.getCurrentState()==1) {//2 == gameoverstate
			int rows = game.board.size;
			int cols = game.board.size;
			int rowHt = height / (rows);
			int rowWid = width / (cols);
			int sizeFont=rowHt;
			if (rowWid<sizeFont) sizeFont=rowWid;
			sizeFont=sizeFont/3;

			// draw the numbers
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (game.board.board[i][j] != 0)
					{
						int value = game.board.board[i][j];
						int n=(int)(Math.log(value)/Math.log(2));//get the number in form of 1-n
						g.setColor(c[Math.floorMod(n, c.length)]);
						g.fillRect(rowWid*j, rowHt*i, rowWid, rowHt);
						g.setColor(getTextColor(value));
						g.setFont(new Font("Default",Font.PLAIN,sizeFont));;

						g.drawString(Integer.toString(value), (j + 1) * rowWid - (rowWid / 2) - getTextShifting(value),
								(i + 1) * rowHt - (rowHt / 2));
					}
				}
			}
			g.setColor(Color.white);
			for (int i = 0; i < rows; i++)
				g.drawLine(0, i * rowHt, width, i * rowHt);
			for (int i = 0; i <= cols; i++)
				g.drawLine(i * rowWid, 0, i * rowWid, height);
			
			// Display Score
			g.setColor(Color.black);
			g.setFont(new Font("Default",Font.PLAIN,sizeFont));;
			g.drawString("Your Score:", width + 40 ,
					100);
			g.drawString(Integer.toString(game.observers.get(0).score) , width + 40 ,
							140);

		} else if (game.context.state.getCurrentState() == 0) {
			g.drawString("Press 'S' to start", width / 3, height / 3);
			g.drawString("Press 'E' to exit",width / 3 + 3, height / 3 + 40);

		} else if (game.context.state.getCurrentState()==2) {
			g.drawString("Game Over!", width / 2 - 40, height / 2 - 10);
			g.drawString("Your Score: " + game.observers.get(0).score, width / 2 - 45, height / 2 + 10);
			g.drawString("Press space to go to the menue!", width / 2 - 50,height / 2 + 20);//TODO not sure if this is correct
		}
	}

	private Color getTextColor(int value){
		return (value >= 256) ? Color.white : Color.black; 
	}
	
	private int getTextShifting(int value){
		if (value < 10)
			return 0;
		else if (value < 100)
			return 10;
		else 
			return 20;
	}

}
