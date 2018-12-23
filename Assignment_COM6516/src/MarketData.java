
public class MarketData {
	
	private int month, day, year;
	private double high, low, open, close, volumn;
	
	public MarketData() {
	}
	
	public MarketData(int month, int day, int year, 
			double open,double high, double low,  double close, double volumn) {
		this.month = month;
		this.day = day;
		this.year = year;
		this.high = high;
		this.low = low;
		this.open = open;
		this.close = close;
		this.volumn = volumn;
	}

	/*
	 * All getter and Setter
	 */
	public String getDate() {
		return month+"/"+day+"/"+year;
	}

	public void setDate(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public double getVolumn() {
		return volumn;
	}

	public void setVolumn(double volumn) {
		this.volumn = volumn;
	}
}
