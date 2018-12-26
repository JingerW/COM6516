import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.stream.IntStream;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Class: Components
 * Desc: contains functions for making different components like JButton, JComboBo etc.
 */
public class Components {

	public Components() {}
	
	/*
	 * Name: makeComboBox
	 * Desc: make a combobox component and add to the panel, return this combobox.
	 * @param p JPanel
	 * @param l String array to put into combobox
	 * @param e actionlistener
	 */
	public JComboBox makeComboBox(JPanel p, String[] list, String label, ActionListener e) {
		JComboBox b = new JComboBox(list);
		if (label != "") {
			JLabel l = new JLabel(label);
			p.add(l);
		}
		b.addActionListener(e);
		p.add(b);
		return b;
	}
	
	/*
	 * Name: makeJButton
	 * Desc: make a button component and add to the panel, return this button.
	 * @param p JPanel
	 * @param l String label for this button
	 * @param e actionlistener
	 */
	public JButton makeJButton(JPanel p, String l, ActionListener e) {
		JButton b = new JButton(l);
		b.addActionListener(e);
		p.add(b);
		return b;
	}
	
	/*
	 * Name: makeJCheckBox
	 * Desc: make a check box component and add to the panel, return this check box.
	 * @param p JPanel
	 * @param l String label for this check box
	 * @param e ItemListener
	 * @param state selected state at the beginning
	 */
	public JCheckBox makeJCheckBox(JPanel p, String l, ItemListener ie, boolean state, Color color) {
		JCheckBox c = new JCheckBox(l);
		c.setForeground(color);
		if (state == true) {
			c.setSelected(true);
		}
		c.addItemListener(ie);
		p.add(c);
		return c;
	}
		
	
	/*
	 * Name: numberList
	 * Desc: return a String array that contains a range of integers, used for create date string arrays.
	 * @param start startInclusive integer
	 * @param end endInclusive integer
	 */
	public String[] numberList(int start, int end) {
		String[] li = IntStream.rangeClosed(start, end).mapToObj(Integer::toString).toArray(String[]::new);
		return li;
	}

}
