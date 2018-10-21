/** 
* Examples of problems associated with equality
* 
* @version 1.1 26 August 2011
* 
* @author Richard Clayton  (r.h.clayton@sheffield.ac.uk)
*/

public class ProblemsWithEquals{
    public static void main(String[] args){
	String wholePhrase1 = "Hello World";
	String firstPart = "Hello Worl";
	String lastLetter = "d";
	String wholePhrase2 = firstPart + lastLetter;

	// first test looks at REFERENCE
	System.out.println("Using if (string1 == string2) gives");
	if (wholePhrase1 == wholePhrase2) {
	    System.out.println("'"+wholePhrase1+"' and '"+wholePhrase2+
			       "' are equal\n");
	} else {
	    System.out.println("'"+wholePhrase1+"' and '"+wholePhrase2+
			       "' are NOT equal\n");
	} // if/else

	// second test looks at CONTENTS
	System.out.println("But using if (string1.equals(string2)) gives");
	if (wholePhrase1.equals(wholePhrase2)) {
	    System.out.println("'"+wholePhrase1+"' and '"+wholePhrase2+
			       "' are equal");
	} else { 
	    System.out.println("'"+wholePhrase1+"' and '"+wholePhrase2+
			       "' are NOT equal");
	} //if/else
    }
}