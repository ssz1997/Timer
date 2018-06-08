package thread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;
import javax.swing.Timer;

public class CountDown implements ActionListener{
	
	private double i = 9.9;
	private MyPanel display;
    private Timer timer;
	
	
	public CountDown(MyPanel panel) {
		timer = new Timer(100, this);
		this.display = panel;
		timer.start();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (timer == null) {
			return;
		}
		else {
			if (i >= 0 && e.getSource() == timer) {
				System.out.print(i);
				display.setValue(i);
				display.repaint();
				i -= 0.1;
			}
	
		}
	}
	
	public void stop() {
		timer = null;
	}
}
