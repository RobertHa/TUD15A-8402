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
		
		Color[] c={Color.cyan,Color.orange,Color.lightGray,Color.magenta};		
		width = getSize().width;
		height = getSize().height;
		
		if (game.context.state.getCurrentState()!=2) {//2 == gameoverstate
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
						int n=(int)(Math.log(game.board.board[i][j])/Math.log(2));//get the number in form of 1-n
						g.setColor(c[Math.floorMod(n, 4)]);
						g.fillRect(rowWid*j, rowHt*i, rowWid, rowHt);
						g.setColor(Color.black);
						g.setFont(new Font("Default",Font.PLAIN,sizeFont));;
						g.drawString(Integer.toString(game.board.board[i][j]), (j + 1) * rowWid - (rowWid / 2),
								(i + 1) * rowHt - (rowHt / 2));
					}
				}
			}
			for (int i = 0; i < rows; i++)
				g.drawLine(0, i * rowHt, width, i * rowHt);
			for (int i = 0; i < cols; i++)
				g.drawLine(i * rowWid, 0, i * rowWid, height);
		} else {
			g.drawString("Game Over!", width / 2 - 40, height / 2 - 10);
			g.drawString("Your Score: " + game.board.score, width / 2 - 45, height / 2 + 10);
			g.drawString("Press space to restart!", width / 2 - 50,height / 2 + 20);//TODO not sure if this is correct
		}
	}

	public void update() {

	}

}
