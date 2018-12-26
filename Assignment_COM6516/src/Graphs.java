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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

/*
 * Class: graphs
 * Desc: JPanel for drawing data.
 * Author: Jingjing Wang
 */
public class Graphs extends JPanel{

	/*
	 * All declarations
	 */
	public final static int BORDER_WIDTH = 10;
	private int padding = 50;
	private float[] pattern = {10};
	private ArrayList<MarketData> MD;
	private ArrayList<Line2D> lines;
	private ArrayList<Ellipse2D> dotes;
	private double unitDataX, unitDataY, max, min;
	private int panelH, panelW, originX, originY, unitYaxis;
	private Color color1 = new Color(255,0,0,255);
	private Color color2 = new Color(255,255,0,0);
	private Color color3 = new Color(0,255,0,0);
	private Color color4 = new Color(0,0,255,0);
	private Color color5 = new Color(0,255,255,255);
	private String dataname;
	private boolean volumn = false;
	
	private BasicStroke line = new BasicStroke(1);
	private BasicStroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, pattern, 0);
	
	/*
	 * Initiation
	 * set border, layout, background color and calculate origin's position based on size of the current frame
	 */
	public Graphs(Container c, ArrayList<MarketData> MarketData) {
		this.MD = MarketData;
		this.dotes = new ArrayList<>();
		this.lines = new ArrayList<>();
		
		// get container's size and set position for the origin
		panelH = c.getPreferredSize().height;
		panelW = c.getPreferredSize().width;
		originX = panelW-(BORDER_WIDTH*2+padding);
		originY = panelH-(BORDER_WIDTH*2+padding*2);
		
		setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(BORDER_WIDTH, BORDER_WIDTH, BORDER_WIDTH, BORDER_WIDTH), new EtchedBorder()));
		setLayout(null);
		setBackground(Color.WHITE);
		c.add(this);
	}
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// draw x and y axis
		g2.drawLine(padding, padding, padding, originY);
		g2.drawLine(padding, originY, originX, originY);

		// set storke and color then draw the graph, initially only data of OPEN is visible
		g2.setStroke(line);
		
		if (volumn == false) {
			g2.setColor(color1);
			drawGraph("OPEN");
			for (Ellipse2D dote: dotes) {
				g2.draw(dote);
			}
			for (Line2D line: lines) {
				g2.draw(line);
			}
			
			g2.setColor(color2);
			drawGraph("HIGH");
			for (Ellipse2D dote: dotes) {
				g2.draw(dote);
			}
			for (Line2D line: lines) {
				g2.draw(line);
			}
			
			g2.setColor(color3);
			drawGraph("LOW");
			for (Ellipse2D dote: dotes) {
				g2.draw(dote);
			}
			for (Line2D line: lines) {
				g2.draw(line);
			}
			
			g2.setColor(color4);
			drawGraph("CLOSE");
			for (Ellipse2D dote: dotes) {
				g2.draw(dote);
			}
			for (Line2D line: lines) {
				g2.draw(line);
			}
			
			// get labels
			drawXLables(g2);
		}
		else {
			g2.setColor(color5);
			drawGraph("VOLUMN");
			for (Ellipse2D dote: dotes) {
				g2.draw(dote);
			}
			for (Line2D line: lines) {
				g2.draw(line);
			}
			// get labels
			drawXLables(g2);
		}

	}
	
	/*
	 * Name: getVolumn
	 * Desc: if Volumn is selected, display volumn only becuase it has different unit(in e6)
	 * @param v set volumn to true or false
	 */
	public void getVolumn(boolean v) {
		this.volumn = v;
	}
	
	/*
	 * Name: setColor
	 * Desc: set opacity of each color.
	 * @param int selected color
	 * @param alpha opacity
	 */
	public void setColor(int num, int alpha) {
		if (num == 1) {
			color1 = new Color(255,0,0,alpha);
		}
		else if (num == 2) {
			color2 = new Color(255,255,0,alpha);
		}
		else if (num == 3) {
			color3 = new Color(0,255,0,alpha);
		}
		else if (num == 4) {
			color4 = new Color(0,0,255,alpha);
		}
		else {
			color5 = new Color(0,255,255,alpha);
		}
	}
	
	
	/*
	 * Name: drawXLables
	 * Desc: draw out x axis and all labels on to the panel
	 * @param g2 Graphics2D
	 */
	public void drawXLables(Graphics2D g2) {
		int month = 0;
		g2.setStroke(dashed);
		g2.setColor(new Color(187, 190, 193));
		
		// y axis labels
		unitYaxis = (originY - padding)/10;
		for (int i=0;i<10;i++) {
			g2.drawLine(padding, padding + (unitYaxis*i), originX, padding + (unitYaxis*i));
			
			JLabel labelY = new JLabel(String.valueOf(Math.round(min+(unitYaxis*(9-i)))));
			labelY.setSize(30, 10);
			labelY.setLocation(padding-30, padding + (unitYaxis*i));
			this.add(labelY);
		}
		
		
		// x axis labels
		for (int i=0;i<MD.size();i++) {
			if (month != MD.get(MD.size()-1-i).getMonth()) {
				JLabel labelX = new JLabel(MD.get(MD.size()-1-i).getDate());
				labelX.setSize(50, 10);
				labelX.setLocation((int) Math.round(padding+unitDataX*i), originY+10);
				if (i != 0) {
					g2.drawLine((int) Math.round(padding+unitDataX*i), padding, (int) Math.round(padding+unitDataX*i), originY);
				}
				this.add(labelX);
				month = MD.get(MD.size()-1-i).getMonth();
			}	
		}
	}
	
	/*
	 * Name: drawGraph
	 * Desc: to set which data to paint and the line color
	 * @param dataname set which data to paint
	 * @param colorname line color
	 */
	public void drawGraph(String dataname) {
		this.dataname = dataname;
		this.drawGraph();
	}
	
	/*
	 * Name: drawGraph
	 * Desc: draw out data graph on to the panel
	 * @param g2 Graphics2D
	 */
	public void drawGraph() {
		dotes = new ArrayList<>();
		lines = new ArrayList<>();
		
		// get units for each specific data
		// get maximum and minimum value of the data and stretch the graph based on these two values
		unitDataX = (originX - padding)/(double)(MD.size());
		max = getMaxOrMin(MD, dataname, 0)+20;
		min = getMaxOrMin(MD, dataname, 1)-20;
		unitDataY = (originY - padding)/(max-min);
		System.out.println(getMaxOrMin(MD, dataname, 0));
		System.out.println(getMaxOrMin(MD, dataname, 1));
		
		// draw values
		for (int i=0;i<MD.size();i++) {
			// draw each dote
			dotes.add(new Ellipse2D.Double(padding+(i*unitDataX), originX-((MD.get(MD.size()-1-i).getData(dataname)-min)*unitDataY), 1, 1));
//			g2.draw(new Ellipse2D.Double(padding+(i*unitDataX), originX-((MD.get(MD.size()-1-i).getData(dataname)-min)*unitDataY), 1, 1));
			if ((i+1)<MD.size()) {
				// draw lines between dotes
				lines.add(new Line2D.Double(padding+(i*unitDataX), originX-((MD.get(MD.size()-1-i).getData(dataname)-min)*unitDataY), padding+((i+1)*unitDataX), originX-((MD.get(MD.size()-2-i).getData(dataname)-min)*unitDataY)));
//				g2.draw(new Line2D.Double(padding+(i*unitDataX), originX-((MD.get(MD.size()-1-i).getData(dataname)-min)*unitDataY), padding+((i+1)*unitDataX), originX-((MD.get(MD.size()-2-i).getData(dataname)-min)*unitDataY)));
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
				list.add(MD.get(i).getVolumn()/(1e6));
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

