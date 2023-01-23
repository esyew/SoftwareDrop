//Erick Grant
//CST 239
//Jan 22 2022
//This is my own work
package app;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
/**
* 
* @author Erick Grant
* Tester for Person class.
*/
class personTests {

	@Test
	void test() throws URISyntaxException, IOException {
		
		
		
		Person myPerson = new Person("John Doe", 4634636, 37, "John@example.com");
		String name = myPerson.getName();
		int idNumber = myPerson.getIdNumber();
		String emailAddress = myPerson.getEmailAddress();
		var age = myPerson.getAge();
		
		//Basic Assertions
		assertEquals("John Doe", name);
		assertEquals(4634636, idNumber);
		assertEquals(37, age);
		assertEquals("John@example.com", emailAddress);
		
		//Test increaseAge(1)
		age = myPerson.increaseAge(1);
		assertEquals(38, age);
		
		//Test prepare email
		String goodMessage = "mailto:John@example.com?body=ILikeCheese";
		String outputMessage = Person.sendEmail(emailAddress, "ILikeCheese");
		assertEquals(goodMessage, outputMessage);
		
	}

}
