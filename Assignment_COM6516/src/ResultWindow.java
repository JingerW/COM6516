import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class ResultWindow extends JFrame implements ActionListener, ItemListener {
	
	public final static int WIDTH = 1000, HEIGHT = 900;
	private Components make;
	private JPanel graph;
	private ArrayList<MarketData> MD;
	private JCheckBox open, close, high, low;

	
	public ResultWindow(ArrayList<MarketData> MarketData) {
		this.MD = MarketData;
		
		// set size, position, icon, and title for the JFrame
		setTitle("Stock Market Result");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		setLocation(new Point(dim.width/10+StartWindow.WIDTH,0));
		Container contentPane = this.getContentPane();
//		setLayout(new BoxLayout(contentPane, BoxLayout.LINE_AXIS));
		contentPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		pack();
		
		// set border
		
		make = new Components();
		
		graph = new Graphs(contentPane, MD);
		
		JPanel buttons = new JPanel();
		open  = make.makeJCheckBox(buttons, "OPEN", this, true);
		high  = make.makeJCheckBox(buttons, "HIGH", this, false);
		low   = make.makeJCheckBox(buttons, "LOW", this, false);
		close = make.makeJCheckBox(buttons, "CLOSE", this, false);
		contentPane.add(buttons, "North");
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void itemStateChanged(ItemEvent ie) {
		Object source = ie.getItemSelectable();
	
		if (ie.getStateChange() == ItemEvent.DESELECTED) {
			if (source == open) {
				System.out.println("open is deselected");
			}
			else if (source == high) {
				System.out.println("high is deselected");
			}
			else if (source == low) {
				System.out.println("low is deselected");
			}
			else if (source == close) {
				System.out.println("close is deselected");
			}
		}
		else {
			if (source == open) {
				System.out.println("open is selected");
			}
			else if (source == high) {
				System.out.println("high is selected");
			}
			else if (source == low) {
				System.out.println("low is selected");
			}
			else if (source == close) {
				System.out.println("close is selected");
			}
		}
		
	}
	
}
