
public class Tutor extends Person{
	
	private String office;
	
	public Tutor(String name, String dob, String o) {
		super(name, dob);
		office = o;
	}
	
	public String getOffice() {
		return(office);
	}
	
	@Override
	public String toString() {
		String n = super.toString();
		return(n + "\nOffice number of this tutor: " + office);
	}
}