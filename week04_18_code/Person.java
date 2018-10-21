
public class Person {
	
	private String name;
	private String dob;
	
	public Person(String n, String d) {
		name = n;
		dob = d;
	}
	
	public String getName() {
		return(name);
	}
	
	public String getDOB() {
		return(dob);
	}
	
	public String toString() {
		return("Name: "+name+" Date of Birth: "+dob);
	}
}
