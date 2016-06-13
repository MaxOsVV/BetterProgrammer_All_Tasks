package task2;

/*
Please implement this method to
return a String with the binary representation of any number n, where n >= 0.
Example: "101" is a binary representation of 5
*/

public class BetterProgrammerTask {

    public static String getBinaryRepresentation(int n) {
        /*
         Please implement this method to
         return a String with the binary representation of any number n, where n >= 0.
         Example: "101" is a binary representation of 5
        */
    	
    	String s = Integer.toString( n, 2 );
    	
    	return s;
    }

    // Short test.
	public static void main(String[] args) {
		System.out.println( BetterProgrammerTask.getBinaryRepresentation( 5 ) );
	}
}
