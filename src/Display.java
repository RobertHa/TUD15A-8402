
import java.awt.Frame;
import java.awt.event.*;

public class Display extends Frame{
	Game game;

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
					game.key = e.getExtendedKeyCode();
					game.context.state.action(game);
					game.display.getComponent(0).repaint();
				}

				@Override
				public void keyReleased(KeyEvent e) {
				}
			}
		);
		pack();
	}
}
