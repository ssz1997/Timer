package thread;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ShowGUI {
		
	private static void createAndShowGUI() {
		JFrame f = new JFrame("CountDown");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new MyPanel());
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				createAndShowGUI();
			}
		});
	}    
}
