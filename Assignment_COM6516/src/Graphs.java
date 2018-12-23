import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
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
		
		panelH = c.getPreferredSize().height;
		panelW = c.getPreferredSize().width;
//		setPreferredSize(new Dimension(panelH, panelW));
		System.out.println("Height: "+panelH+"  Weight: "+panelW);

		setBackground(Color.WHITE);
		c.add(this);
		
		//tests
		for(int i=0;i<maxData;i++) {
			testList.add((double)r.nextDouble()*maxTest);
		}
		
	}
	
	private int padding = 10;
	private float[] pattern = {10};
	private BasicStroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, pattern, 0);
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// draw lines for x and y
		g2.drawLine(padding, padding, padding, panelH-padding*4);
		g2.drawLine(padding, panelH-padding*4, panelW-padding*4, panelH-padding*4);
		
		g2.setStroke(dashed);
		g2.setColor(new Color(187, 190, 193));
		for (int i=1;i<10;i++) {
			g2.drawLine(padding + (((panelW-padding*4)/10)*i), padding, padding + (((panelW-padding*4)/10)*i), panelH-padding*4);
		}
		for (int i=1;i<10;i++) {
			g2.drawLine(padding, padding + (((panelH-padding*4)/10)*i), panelW-padding*4, padding + (((panelH-padding*4)/10)*i));
		}
//		double xScale = ();
	}
	
}

