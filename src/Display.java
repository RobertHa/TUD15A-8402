
import java.awt.Frame;
import java.awt.event.*;

public class Display extends Frame{
	Game game;
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
				switch (game.context.state.getCurrentState()){//2  == gameover
					case 0:
						System.out.println("gamestate: "+game.context.state.getCurrentState());
						if (key == KeyEvent.VK_E||key == KeyEvent.VK_S){
							game.key = key;
							game.context.state.action(game);
						}
						game.display.getComponent(0).repaint();
						break;
					case 1:
						System.out.println("gamestate: "+game.context.state.getCurrentState());
						switch (key) {
							case KeyEvent.VK_UP:
								game.dir = gameLogic.direction.up;
								game.context.state.action(game);
								break;
							case KeyEvent.VK_LEFT:
								game.dir = gameLogic.direction.left;
								game.context.state.action(game);
								break;
							case KeyEvent.VK_DOWN:
								game.dir = gameLogic.direction.down;
								game.context.state.action(game);
								break;
							case KeyEvent.VK_RIGHT:
								game.dir = gameLogic.direction.right;
								game.context.state.action(game);
								break;
						}
						game.display.getComponent(0).repaint();
						break;
					case 2:
						System.out.println("gamestate: "+game.context.state.getCurrentState());
						if (key==KeyEvent.VK_SPACE){
							game.key = key;
							game.context.state.action(game);
						}
						game.display.getComponent(0).repaint();
						break;
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
		pack();
	}


}
