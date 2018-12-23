import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class ResultWindow extends JFrame {
	
	public final static int WIDTH = 800, HEIGHT = 800;
	private Components make;
	private JPanel graph;
	private ArrayList<MarketData> MD;

	
	public ResultWindow(ArrayList<MarketData> MarketData) {
		this.MD = MarketData;
		
		// set size, position, icon, and title for the JFrame
		setTitle("Stock Market Result");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		setLocation(new Point(dim.width/4+StartWindow.WIDTH, dim.height/5));
		Container contentPane = this.getContentPane();
		setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		contentPane.setPreferredSize(new Dimension(HEIGHT, WIDTH));
		pack();
		
		// set border
		((JComponent) contentPane).setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new EtchedBorder()));
		
		make = new Components();
		
		graph = new Graphs(contentPane);
		
		System.out.println("it has "+MD.size()+" data");
	}
	
}
