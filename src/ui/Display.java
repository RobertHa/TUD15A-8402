
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Display extends  Frame implements ActionListener{
	  
		Display(String title, int w, int h, int rows, int cols, int[][] m) {
		    
		setTitle(title);

		// Now create a Canvas and add it to the Frame.
		Grid xyz = new Grid(w, h, rows, cols, m);
		    add(xyz);

		    addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent e) {
		        setVisible(false);
		        dispose();
		        System.exit(0);
		      }
		    });

		    
		    pack();
		  }

		  public static void main(String[] a) {
			int [][] m = new int[4][4];
			for (int i=0; i< 4; i++){
				for (int j=0; j<4;j++){
					m[i][j] = i+j;
				}
			}
		    for (int i=0; i< 4; i++){
		    	for (int j=0; j< 4; j++){
		    		System.out.print(m[i][j]);
		    	}
		    	System.out.println();
		    }
		    new Display("Test", 300, 300, 4, 4, m).setVisible(true);
		  }

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
}
