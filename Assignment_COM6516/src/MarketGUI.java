import javax.swing.JFrame;

public class MarketGUI {
	public static void main(String args[]) {
		JFrame frm = new StartWindow();
//		JFrame frm = new ResultWindow();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
}
