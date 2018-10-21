import java.util.Arrays;

public class Ball {
	
	private int ends;
	private String[] paths;
	
	public Ball(int end, String[] path) {
		ends = end;
		paths = path;
	}
	
	public void setEnds(int e) {
		ends = e;
	}
	
	public void setPaths(String[] p) {
		paths = p;
	}
	
	public int getEnds() {
		return ends; 
	}
	
	public String getPaths() {
		return Arrays.toString(paths);
	}
	
}
