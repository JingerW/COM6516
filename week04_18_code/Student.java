
public class Student extends Person {
	
	private String course;
	
	public Student(String name, String dob, String c) {
		super(name, dob);
		course = c;
	}
	
	public String getCourse() {
		return(course);
	}
	
	@Override
	public String toString() {
		String n = super.toString();
		return(n + "\nThis student has course: " + course); 
	}
}
