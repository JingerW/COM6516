import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartWindow extends JFrame implements ActionListener{
	
	public final static int WIDTH = 400, HEIGHT = 400;
	private Components make;
	private JButton exit, search;
	private String[] year, month, day;
	private JPanel ticker, startDate, endDate, action;
	private ArrayList<MarketData> MD = new ArrayList<>();
	private String[] tickers = { "AAPL", "GOOG", "LIVE"};
	private List<String> month30 = Arrays.asList("4","6","9","11");
	private List<String> month31 = Arrays.asList("1","3","5","7","8","10","12");
	private JComboBox tickerList, startYearList, startMonthList, startDayList, endYearList, endMonthList, endDayList;
	private String testInput = "https://quotes.wsj.com/AAPL/historical-prices/download?MOD_VIEW=page&num_rows=300&startDate=1/1/2018&endDate=12/31/2018";
	
	public StartWindow() {

		// set size, position, icon, and title for the JFrame
		setTitle("MarketGUI");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		setSize(WIDTH,HEIGHT);
		setLocation(new Point(dim.width/10, dim.height/10));
		Container contentPane = this.getContentPane();
		this.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		make = new Components();
		
		// set date string array
		year  = make.numberList(2000, 2018);
		month = make.numberList(1, 12);
		day   = make.numberList(1, 31);
		
		// create panels
		ticker = new JPanel();
		tickerList = make.makeComboBox(ticker, tickers, "Please select ticker: " , this);
		contentPane.add(ticker);
		
		startDate = new JPanel();
		JLabel labelStart = new JLabel("Please select start date: ");
		labelStart.setAlignmentX(CENTER_ALIGNMENT);
		startYearList  = make.makeComboBox(startDate, year , "Year" , this);
		startMonthList = make.makeComboBox(startDate, month, "Month", this);
		startDayList   = make.makeComboBox(startDate, day  , "Day", this);
		contentPane.add(labelStart);
		contentPane.add(startDate);
		
		endDate = new JPanel();
		JLabel labelEnd = new JLabel("Please select end date: ");
		labelEnd.setAlignmentX(CENTER_ALIGNMENT);
		endYearList  = make.makeComboBox(endDate, year , "Year" , this);
		endMonthList = make.makeComboBox(endDate, month, "Month", this);
		endDayList   = make.makeComboBox(endDate, day  , "Day", this);
		contentPane.add(labelEnd);
		contentPane.add(endDate);
		
		action = new JPanel();
		search = make.makeJButton(action, "search", this);
		exit = make.makeJButton(action, "exit", this);
		contentPane.add(action);
	}
	
	
	/*
	 * Name: dayOfMonth
	 * Desc: change available drop down menu items in start/endDayList depend on selected month.
	 * @param month selected month
	 * @param listDay target JComboBox item
	 */
	private void dayOfMonth(String month, JComboBox<String> listDay) {
		if (month30.contains(month) && listDay.getItemCount() != 30) {
			listDay.removeItemAt(listDay.getItemCount()-1);
			while (listDay.getItemCount() != 30) {
				listDay.insertItemAt(Integer.toString(listDay.getItemCount()+1), listDay.getItemCount());
			}
		}
		else if (month31.contains(month) && listDay.getItemCount() != 31) {
			while (listDay.getItemCount() != 31) {
				listDay.insertItemAt(Integer.toString(listDay.getItemCount()+1), listDay.getItemCount());
			}
		}
		else if (Integer.parseInt(month) == 2) {
			while (listDay.getItemCount() != 28) {
				listDay.removeItemAt(listDay.getItemCount()-1);
			}
		}
	}
	
	/*
	 * Name: isInteger/isDouble
	 * Desc: check if the input string can be parsed into int/double
	 * @param s String to be checked
	 */
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
	public static boolean isDouble(String s) {
	    try { 
	        Double.parseDouble(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String input = "";
		Object source = e.getSource();
		
		if (source == exit) {
			System.exit(0);
		}
		
		else if (source == startMonthList) {
			String s = (String) startMonthList.getSelectedItem();
			dayOfMonth(s, startDayList);
		}
		
		else if (source == endMonthList) {
			String s = (String) endMonthList.getSelectedItem();
			dayOfMonth(s, endDayList);
		}
		
		else if (source == search) {
			String t = (String) tickerList.getSelectedItem();
			String startY = (String) startYearList.getSelectedItem();
			String startM = (String) startMonthList.getSelectedItem();
			String startD = (String) startDayList.getSelectedItem();
			String endY = (String) endYearList.getSelectedItem();
			String endM = (String) endMonthList.getSelectedItem();
			String endD = (String) endDayList.getSelectedItem();
			
			input = "https://quotes.wsj.com/"+t+"/historical-prices/download?MOD_VIEW=page&num_rows=300&startDate="+
					startM+"/"+startD+"/"+startY+"&endDate="+endM+"/"+endD+"/"+endY;
			
			try {	
				   URL url = new URL(testInput);
				   Scanner s = new Scanner(url.openStream());
				   s.useDelimiter(",|/|\\n");
				   
				   boolean stop = true;
				   
				   while (stop) {
					   String s1 = s.next();
					   if (isInteger(s1)) {
						   int month = Integer.parseInt(s1);
						   int day = Integer.parseInt(s.next());
						   int year = Integer.parseInt(s.next());
						   Double open = Double.parseDouble(s.next());
						   Double high = Double.parseDouble(s.next());
						   Double low = Double.parseDouble(s.next());
						   Double close = Double.parseDouble(s.next());
						   Double volumn = Double.parseDouble(s.next());
						   MarketData dataForOneDay = new MarketData(month,day,year,open,high,low,close,volumn);
						   MD.add(dataForOneDay);
						   System.out.println(month+","+day+","+year+","+open+","+high+","+low+","+close+","+volumn);
					   }
					   else {continue;}
					   System.out.println();
					   if (!s.hasNext()) {
						   stop = false;
					   }
					   else {continue;}

				   }
					
				}
				catch(IOException ex) {
					System.out.println("there must be something wrong");
					ex.printStackTrace();
				}
			
//			System.out.println(input);
			JFrame result = new ResultWindow(MD);
			result.setVisible(true);
		}
	}
	
}
