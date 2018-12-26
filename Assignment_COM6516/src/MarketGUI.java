import javax.swing.JFrame;

/*
 * Class: MarketGUI
 * Desc: main() function for running application
 * Author: Jingjing Wang
 */
public class MarketGUI {
	public static void main(String args[]) {
		JFrame frm = new StartWindow();

		// for testing
//		JFrame frm = new ResultWindow();

		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
}
