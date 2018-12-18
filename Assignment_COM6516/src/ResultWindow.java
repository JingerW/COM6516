import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ResultWindow extends JFrame {
	
	public final static int WIDTH = 600, HEIGHT = 600;
	private Components make;
	private JPanel graph,graph2,graph3,graph4;

	public ResultWindow() {
		
		// set size, position, icon, and title for the JFrame
		setTitle("Stock Market Result");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		setSize(WIDTH,HEIGHT);
		setLocation(new Point(dim.width/4+StartWindow.WIDTH, dim.height/4));
		setBackground(Color.black);
		Container contentPane = this.getContentPane();
//		setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
//		setLayout(new GridLayout(2,2));
		make = new Components();
		
		graph = new Graphs(contentPane);
//		graph2 = new Graphs(contentPane);
//		graph3 = new Graphs(contentPane);
//		graph4 = new Graphs(contentPane);
	}
	
}
