import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class Graphs extends JPanel{
	
	private Components make;
	private int panelH, panelW;
	private List<Double> testList = new ArrayList<>();
	private Random r = new Random();
	private int maxData = 20;
	private int maxTest = 8;
	
	public Graphs(Container c) {
		
		panelH = ResultWindow.HEIGHT/2-30;
		panelW = ResultWindow.WIDTH/2-30;
		System.out.println("Height: "+panelH+"  Weight: "+panelW);
//		setBorder(new EmptyBorder(10, 10, 10, 10));
//		setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new EtchedBorder()));
//		setBorder(BorderFactory.createLineBorder(Color.black));
		c.add(this);
		
		//tests
		for(int i=0;i<maxData;i++) {
			testList.add((double)r.nextDouble()*maxTest);
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		double xScale = ();
	}
	
}
