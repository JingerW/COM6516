import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Class: ResultWindow
 * Desc: Frame for showing result of csv.
 * Author: Jingjing Wang
 */
public class ResultWindow extends JFrame implements ItemListener {
	
	/*
	 * All declarations
	 */
	public final static int WIDTH = 1000, HEIGHT = 950;
	private Components make;
	private Graphs graph;
	private ArrayList<MarketData> MD;
	private JCheckBox open, close, high, low, volumn;

	/*
	 * Initiation
	 * create 2 panels: drawing panel for displaying the data and a button panel for selecting data
	 */
	public ResultWindow(ArrayList<MarketData> MarketData) {
		this.MD = MarketData;
		
		// set size, position, icon, and title for the JFrame
		setTitle("Stock Market Result");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		setLocation(new Point(dim.width/10+StartWindow.WIDTH,0));
		Container contentPane = this.getContentPane();
		contentPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		pack();
		make = new Components();
		
		// create display panel
		graph = new Graphs(contentPane, MD);
		
		// create button panel
		JPanel buttons = new JPanel();
		open  = make.makeJCheckBox(buttons, "OPEN", this, true, Color.RED);
		high  = make.makeJCheckBox(buttons, "HIGH", this, false, Color.YELLOW);
		low   = make.makeJCheckBox(buttons, "LOW", this, false, Color.GREEN);
		close = make.makeJCheckBox(buttons, "CLOSE", this, false, Color.BLUE);
		volumn = make.makeJCheckBox(buttons, "VOLUMN", this, false, new Color(0,255,255));
		contentPane.add(buttons, "North");
		
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
		Object source = ie.getItemSelectable();
	
		// if the checkbox is deselected, set the opacity to 0 so it will disappear on the screen
		if (ie.getStateChange() == ItemEvent.DESELECTED) {
			if (source == open) {
				System.out.println("open is deselected");
				graph.setColor(1, 0);
				graph.repaint();
			}
			else if (source == high) {
				System.out.println("high is deselected");
				graph.setColor(2, 0);
				graph.repaint();
			}
			else if (source == low) {
				System.out.println("low is deselected");
				graph.setColor(3, 0);
				graph.repaint();
			}
			else if (source == close) {
				System.out.println("close is deselected");
				graph.setColor(4, 0);
				graph.repaint();
			}
			else if (source == volumn) {
				System.out.println("volumn is deselected");
				graph.getVolumn(false);
				graph.repaint();
			}
		}
		// if the checkbox is selected, set the opacity to 255 so it will appear on the screen
		else {
			if (source == open) {
				System.out.println("open is selected");
				graph.setColor(1, 255);
				graph.repaint();
			}
			else if (source == high) {
				System.out.println("high is selected");
				graph.setColor(2, 255);
				graph.repaint();
			}
			else if (source == low) {
				System.out.println("low is selected");
				graph.setColor(3, 255);
				graph.repaint();
			}
			else if (source == close) {
				System.out.println("close is selected");
				graph.setColor(4, 255);
				graph.repaint();
			}
			else if (source == volumn) {
				System.out.println("volumn is selected");
				graph.getVolumn(true);
				graph.repaint();
			}
		}
		
	}
	
}
