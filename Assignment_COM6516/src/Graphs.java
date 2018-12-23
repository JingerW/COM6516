import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class Graphs extends JPanel{

	public final static int BORDER_WIDTH = 10;
	private int padding = 50;
	private float[] pattern = {10};
	private ArrayList<MarketData> MD;
	private double unitDataX, unitDataY, max, min;
	private int panelH, panelW, originX, originY, unitXaxis, unitYaxis;
	
	private BasicStroke line = new BasicStroke(1);
	private BasicStroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, pattern, 0);
	
	
	public Graphs(Container c, ArrayList<MarketData> MarketData) {
		this.MD = MarketData;
		
		// get container's size and set position for the origin
		panelH = c.getPreferredSize().height;
		panelW = c.getPreferredSize().width;
		originX = panelW-(BORDER_WIDTH*2+padding);
		originY = panelH-(BORDER_WIDTH*2+padding);
//		System.out.println("X: "+originX+",   Y: "+originY);

		
		setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(BORDER_WIDTH, BORDER_WIDTH, BORDER_WIDTH, BORDER_WIDTH), new EtchedBorder()));

		setBackground(Color.WHITE);
		c.add(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		drawAxises(g2);
		
		drawGraph(g2);
	
	}
	
	/*
	 * Name: drawAxises
	 * Desc: draw out x and y axis on to the panel
	 * @param g2 Graphics2D
	 */
	public void drawAxises(Graphics2D g2) {
		// draw lines for x and y
		g2.drawLine(padding, padding, padding, originY);
		g2.drawLine(padding, originY, originX, originY);
		
		// dashed lines
		g2.setStroke(dashed);
		g2.setColor(new Color(187, 190, 193));
		unitXaxis = (originX - padding)/10;
		unitYaxis = (originY - padding)/10;
		for (int i=1;i<10;i++) {
			g2.drawLine(padding + (unitXaxis*i), padding, padding + (unitXaxis*i), originY);
			g2.drawLine(padding, padding + (unitYaxis*i), originX, padding + (unitYaxis*i));
		}
	}
	
	/*
	 * Name: drawGraph
	 * Desc: draw out data graph on to the panel
	 * @param g2 Graphics2D
	 */
	public void drawGraph(Graphics2D g2) {
		// get units for each specific data
		// get maximum and minimum value of the data and stretch the graph based on these two values
		unitDataX = (originX - padding)/(double)(MD.size());
		max = getMaxOrMin(MD, "HIGH", 0)+20;
		min = getMaxOrMin(MD, "HIGH", 1)-20;
		unitDataY = (originY - padding)/(max-min);
		
		// draw values
		g2.setStroke(line);
		g2.setColor(Color.black);
		for (int i=0;i<MD.size();i++) {
			// draw each dote
			g2.draw(new Ellipse2D.Double(padding+(i*unitDataX), originX-((MD.get(i).getHigh()-min)*unitDataY), 1, 1));
			if ((i+1)<MD.size()) {
				// draw lines between dotes
				g2.draw(new Line2D.Double(padding+(i*unitDataX), originX-((MD.get(i).getHigh()-min)*unitDataY), 
						                  padding+((i+1)*unitDataX), originX-((MD.get(i+1).getHigh()-min)*unitDataY)));
			}
		}
	}
	
	/*
	 * Name: getMaxOrMin
	 * Desc: get maximum or minimum value of the given data
	 * @param MD MarketData arraylist which will be searched
	 * @param name a string indicates which column's maximum or minimum will be searched
	 * @param maxOrMin Maximum or Minimum option
	 */
	public double getMaxOrMin(ArrayList<MarketData> MD, String name, int maxOrMin) {
		ArrayList<Double> list = new ArrayList<>();
		if (name == "OPEN") {
			for (int i=0;i<MD.size();i++) {
				list.add(MD.get(i).getOpen());
			}
		}
		else if (name == "HIGH") {
			for (int i=0;i<MD.size();i++) {
				list.add(MD.get(i).getHigh());
			}
		}
		else if (name == "LOW") {
			for (int i=0;i<MD.size();i++) {
				list.add(MD.get(i).getLow());
			}
		}
		else if (name == "CLOSE") {
			for (int i=0;i<MD.size();i++) {
				list.add(MD.get(i).getLow());
			}
		}
		else {
			for (int i=0;i<MD.size();i++) {
				list.add(MD.get(i).getVolumn());
			}
		}
		
		if (maxOrMin == 0) {
			return Collections.max(list);
		}
		else {
			return Collections.min(list);
		}
	}
}

