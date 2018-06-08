package thread;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel{
	
	private JButton start;
	private JButton pulse;
	private JButton stop;
	private JLabel title;
	private CountDown counter;
	private double value = 10.0;
	private Font f1 = new Font("Helvetica", Font.PLAIN, 20);
	private boolean counting = true; 
	DecimalFormat df = new DecimalFormat("#.#");
	
	public MyPanel() {
		setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.black));
        //start button
        start = new JButton("Start!");
        start.setLocation(5, 160);
        start.setSize(60, 40);
        add(start);
        start.addMouseListener(new MouseAdapter() {
        	    public void mousePressed(MouseEvent e) {
        		  start();
        	  }
        });
        
        //pulse and resume button
        pulse = new JButton("Pulse/Resume");
        pulse.setLocation(70, 160);
        pulse.setSize(100, 40);
        add(pulse);
        
        //stop button
        stop = new JButton("Stop!");
        stop.setLocation(175, 160);
        stop.setSize(60, 40);
        add(stop);
        stop.addMouseListener(new MouseAdapter() {
        	    public void mousePressed(MouseEvent e) {
        	    	stop();
        	    }
        });
        
        //title lable
        title = new JLabel("Count Down");
        title.setLocation(50, 15);
        title.setSize(170, 50);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.RED);
        add(title);
        
        
	}
	
	protected void start() {
		counter = new CountDown(this);
	}
	
	protected void stop() {
		counter.stop();
		counter = null;
	}
	
	protected void pulse() {
		counting = false;
		
	}
	
	protected void resume() {
		counting = true;
	}
	
	protected void setValue(double newVal) {
		this.value = newVal;
	}

	public Dimension getPreferredSize() {
		return new Dimension(240, 210);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(f1);
		FontMetrics fm = g.getFontMetrics();
		String val = df.format(value);
		int w = fm.stringWidth(val);
		
		g.drawString(String.valueOf(val), 120-w/2, 100);
	}
	
}
