
import java.awt.Frame;
import java.awt.event.*;

public class Display extends Frame{
	Game game
	//int rows, int cols, int[][] m, gameLogic M
	Display(String title, int w, int h, Game g) {
		this.game = g;
				
		setTitle(title);
		// Now create a Canvas and add it to the Frame.
		Grid xyz = new Grid(w, h, game);
		add(xyz);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getExtendedKeyCode();
				if (game.context.state.getCurrentState()!=2){//2  == gameover
					switch (key) {
					case KeyEvent.VK_UP:
						game.context.state.action();
						break;
					case KeyEvent.VK_LEFT:
						doStuff(1);
						break;
					case KeyEvent.VK_DOWN:
						doStuff(2);
						break;
					case KeyEvent.VK_RIGHT:
						doStuff(3);
						break;
					}
				}
				else{
					if (key==KeyEvent.VK_SPACE){
						doStuff(4);
						
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
		pack();
	}



	void doStuff(int dir) {

		switch (dir) {
		case 0:
			//System.out.println("swipe up: \n");
			M.swipe(gameLogic.direction.up);
			this.getComponent(0).repaint();
			//M.show();
			break;
		case 1:
			//System.out.println("swipe left: \n");
			M.swipe(gameLogic.direction.left);
			this.getComponent(0).repaint();
			//M.show();
			break;
		case 2:
			//System.out.println("swipe down: \n");
			M.swipe(gameLogic.direction.down);
			this.getComponent(0).repaint();
			//M.show();
			break;
		case 3:
			//System.out.println("swipe right: \n");
			M.swipe(gameLogic.direction.right);
			this.getComponent(0).repaint();
			//M.show();
			break;
		case 4:	
			M.restart(M.sizeMatrix);
			this.getComponent(0).repaint();
			//M.show();
			break;
			
		}
	}

}
