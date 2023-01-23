//Erick Grant
//CST 239
//Jan 22 2022
//This is my own work, except for the core of the sendMail function.

package app;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
*
* @author Erick Grant
* 
*/
public class Person {

	private int idNumber;
	private int age;
	private String emailAddress, name;
	
	public Person(String name, int idNumber, int age, String emailAddress ) {
		//Set variables relative to class
		super();
		this.age = age;
		this.idNumber = idNumber;
		this.emailAddress = emailAddress;
		this.name = name;
		
	}
	
	
	/**
	 * 
	 * @param idNumber of Person
	 * @return the idNumber of the object called
	 */
	public int getIdNumber() {
		//Return ID Number
		return idNumber;
	}


	/**
	 * @return the age
	 * @param This when called returns the age of the object given.
	 */
	public int getAge() {
		//Return current age, will change with increaseAge()
		return age;
	}
	
	/**
	 * @return String that is ready to be put into a web browser as a backup option, normally not used.
	 * @param  name sendEmail
	 * @param		This composes a email that is ready for the user to send.
	 */
	public static String sendEmail(String address, String body) throws URISyntaxException, IOException {
		//Requires having a default mail client enabled, if fails will throw a URI to console which should be a fail-safe.
		
		//Using https://stackoverflow.com/questions/2357895/java-open-default-mail-application-and-create-new-mail-and-populate-to-and-subj#2357924
		
		// Should open in default mail application, uncomment the println and enter into a web browser if issues arise. 
		
		//Tester code, delete for any production
		System.out.println("	TEST: Hello I am in sendEmail()");
		
		//Using https://stackoverflow.com/questions/31610444/how-to-replace-space-with-20-in-java#31610480
		body = body.replaceAll(" ", "%20");
		body = body.replaceAll("\n", "%0D%0A");
		
		String message = "mailto:" + address + "?body=" + body;
		
		Desktop desktop;
		if (Desktop.isDesktopSupported() 
			    && (desktop = Desktop.getDesktop()).isSupported(Desktop.Action.MAIL)) {
			
			URI uri = URI.create(message);
			desktop.mail(uri);
			
			} else {
				  System.out.println("Please enter this into a web browser, to create the email.");
				  
				  System.out.println(message);
				  
			  throw new RuntimeException("Error using Desktop for mail generation)");

			}
		return message;
	}


	/** @return new age after increase.
	 * @param int to increase the age by
	 * 
	 */
	public int increaseAge(int amount) {
		System.out.println("	TEST: I am in increaseAge()");
		age += amount;
		System.out.println("	TEST: The new age is: " + age);
		return age;
	}
	/**
	 * @return the emailAddress
	 * @param This when called returns the emailAddress of the object given.
	 */
	public String getEmailAddress() {
		return emailAddress;
	}


	/**
	 * @return the name of person
	 * @param This when called returns the name of the object given.
	 */
	public String getName() {
		return name;
	}

	



	//Main
	/**
	 * 
	 * @param Code that runs at the start, does not use Scanner.
	 */
	public static void main(String[] args) throws URISyntaxException, IOException {
		
		Person myPerson = new Person("John Doe", 4634636, 37, "John@example.com");
		
		//init variables
		String name = myPerson.getName();
		int idNumber = myPerson.getIdNumber();
		String emailAddress = myPerson.getEmailAddress();
		var age = myPerson.getAge();
		
		//Print out current age
		System.out.println(name + " is " + age + " years old.\n");
		
		//Increase age
		age = myPerson.increaseAge(2);
		//Add blank line, then a updated age.
		System.out.println();
		System.out.println("" + name + " is now " + age + " years old.");
		
		//Add a println, to add a line from the testing lines. 
		System.out.println();
		//System.out.println("email: " + emailAddress);
		sendEmail(emailAddress, "This was composed by Erick Grant\nsay hi to " + name + " (" + idNumber + ") " + "I hear they are " + age);
		
	}

}

/*		Paragraph for the console output.
 * First line of console states of initial age & name, using current parameter was 37.
 * Enter a blank line
 * Testing line, outputs new age to console.
 * Prints new age and name to console
 * In email body that is generated, gives name, age, and ID Number;
 *  this was done using Desktop.action.mail which is java's mail handling system
 *  Opens URI with "mailto:" in system, which should open outlook or another mail application. 
*/




