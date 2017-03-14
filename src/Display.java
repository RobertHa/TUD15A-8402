
import java.awt.Frame;
import java.awt.event.*;

public class Display extends Frame {
	private gameLogic M;

	Display(String title, int w, int h, int rows, int cols, int[][] m, gameLogic M) {

		setTitle(title);
		this.M = M;
		// Now create a Canvas and add it to the Frame.
		Grid xyz = new Grid(w, h, M);
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
				switch (key) {
				case KeyEvent.VK_UP:
					doStuff(0);
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

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
		pack();
	}

	public static void main(String[] a) {
		int size = 4;
		gameLogic M = new gameLogic(size);
		new Display("Test", 300, 300, M.sizeMatrix, M.sizeMatrix, M.matrix, M).setVisible(true);
	}

	void doStuff(int dir) {

		switch (dir) {
		case 0:
			System.out.println("swipe up: \n");
			System.out.println(M);
			M.swipe(gameLogic.direction.up);
			System.out.println("i got through swipe");
			this.getComponent(0).repaint();
			M.show();
			break;
		case 1:
			System.out.println("swipe left: \n");
			M.swipe(gameLogic.direction.left);
			this.getComponent(0).repaint();
			M.show();
			break;
		case 2:
			System.out.println("swipe down: \n");
			M.swipe(gameLogic.direction.down);
			this.getComponent(0).repaint();
			M.show();
			break;
		case 3:
			System.out.println("swipe right: \n");
			M.swipe(gameLogic.direction.right);
			this.getComponent(0).repaint();
			M.show();
			break;
		}
	}

}
