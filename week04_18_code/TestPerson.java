
public class TestPerson {
	
	public static void main(String[] arg) {
		
		Person Tom = new Person("Tom","01/01/1995");
		Student Tim = new Student("Tim", "02/02/1996","computer sicence");
		Tutor Tam = new Tutor("Tam", "03/03/1966","123456789");
		
		System.out.println(Tom.toString());
		System.out.println(Tim.toString());
		System.out.println(Tam.toString());
		
	}
	
}
