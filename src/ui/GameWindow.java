
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class GameWindow {

	   private JFrame mainFrame;
	   private JLabel headerLabel;
	   private JPanel matrixPanel;
	   
	   public GameWindow(){
		      init();
	   }

	   private void init(){
	      mainFrame = new JFrame("2048");
	      mainFrame.setSize(500,500);
	      mainFrame.setLayout(new GridLayout(3, 1));

	      headerLabel = new JLabel("",JLabel.CENTER);
	      
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
	      matrixPanel = new JPanel();
	      matrixPanel.setSize(400, 400);

	      mainFrame.add(headerLabel);
	      mainFrame.add(matrixPanel);
	      mainFrame.setVisible(true);  
	   }
	   private void showGridLayoutDemo(){
		      headerLabel.setText("Playing...");      
		      
		      JPanel panel = new JPanel();
		      panel.setSize(150,150);
		      GridLayout layout = new GridLayout(4,4);
		      
		      panel.setLayout(layout);
		      for (int i=0; i<16; i++){
		    	  panel.add(new JButton(Integer.toString(i + 1)));
		      }
		      matrixPanel.add(panel);
		      mainFrame.setVisible(true);  
	   }
	   
	   public static void main(String[] args){
		      GameWindow gw = new GameWindow();  
		      gw.showGridLayoutDemo(); 
	   }
	   
}
