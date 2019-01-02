
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
		return month+"/"+year;
	}
	
	public int getMonth() {
		return month;
	}

	public void setDate(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public double getData(String dataname) {
		if (dataname == "OPEN") {
			return open;
		}
		else if (dataname == "HIGH") {
			return high;
		}
		else if (dataname == "LOW") {
			return low;
		}
		else if (dataname == "CLOSE") {
			return close;
		}
		else {
			return volumn/1e6;
		}
	}

	public double getHigh() {
		return high;
	}

	public double getLow() {
		return low;
	}

	public double getOpen() {
		return open;
	}

	public double getClose() {
		return close;
	}

	public double getVolumn() {
		return volumn;
	}

}
