package email_app;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmailAppTest {
	// Partition the input as follows:
	//	createAlternateEmail(altFirstname, altLastname) -> boolean
	//		altFullname.equalsIgnoreCase(fullname): true, false
	//		altFirstname.equalsIgnoreCase(altLastname): true, false
	//		alternate email: exists, doesn't exist
	//
	//  getName() -> fullname
	//		firstname.equalsIgnoreCase(lastname): true, false
	//		Include tests where alternate email exists
	//
	//	getAltName() -> altFullname
	//		altFirstname.equalsIgnoreCase(altLastname): true, false
	//		alternate email: exists, doesn't exist
	//
	//	getDepartmentCode() -> departmentCode
	//		departmentCode: exists, wasn't set during email creation
	//
	//  getMailCapacity() -> mailCapacity
	//	
	//	getEmailAddress() -> emailAddress
	//		firstname.equalsIgnoreCase(lastname): true, false
	//		departmentCode: exists, wasn't set during email creation
	//	
	//	getAltEmailAddress() -> altEmailAddress
	//		firstname.equalsIgnoreCase(lastname): true, false
	//		departmentCode: exists, wasn't set during email creation
	//		
	//  resetPassword(newPassword) -> boolean
	//		newPassword == current password: true, false
	//
	//  setMailCapacity(newMailCapacity) -> boolean
	//		newMailCapacity == current mailCapacity
	//		newMailCapacity < current mailCapacity
	//		newMailCapacity > current mailCapacity
	//
	// Coverage: Exhaustive enumeration of partitions
	
	// Tests for createAlternateEmail()
	@Test
	// covers altFullname.equalsIgnoreCase(fullname) == true
	// 		  altFirstname.equalsIgnoreCase(altLastname) == false
	//		  alternate email doesn't exist
	public void testCreateAlternateEmail_AltEqualsMain() {
		String firstname = "foo";
		String lastname = "bar";
		String fullname = firstname + "." + lastname;
		Email email = new Email(firstname, lastname, "001", "12345678");
		boolean altEmailCreated = email.createAlternateEmail(firstname, lastname);
		
		assertTrue("Expected successful email creation", fullname.equalsIgnoreCase(email.getName()));// just to make sure the test is ok
		assertFalse("Expected unsuccessful alternate email creation", altEmailCreated);
		assertEquals("Expected no alternate email", 0, email.getAltEmailAddress().length());
	}	
	@Test
	// covers altFullname.equalsIgnoreCase(fullname) == true
	//		  altFullname.equalsIgnoreCase(fullname) == false
	// 		  altFirstname.equalsIgnoreCase(altLastname) == true
	//		  alternate email exists
	public void testCreateAlternateEmail_AltEqualsMainExists() {
		String firstname = "foo";
		String lastname = "bar";
		String fullname = firstname + "." + lastname;
		Email email = new Email(firstname, lastname, "001", "12345678");
		boolean altEmailCreated_1 = email.createAlternateEmail(lastname, lastname);
		boolean altEmailCreated_2 = email.createAlternateEmail(firstname, lastname);
		String altFullname = lastname + "." + lastname;
		
		assertFalse("Expected successful alternate email creation", altEmailCreated_1);
		assertFalse("Expected unsuccessful alternate email creation", altEmailCreated_2);
		assertTrue("Expected unchanged main email address", fullname.equalsIgnoreCase(email.getName()));
		assertTrue("Expected unchanged alternate email", altFullname.equalsIgnoreCase(email.getAltEmailAddress()));
	}
	
	// Tests for getName()
	@Test
	// covers firstname.equalsIgnoreCase(lastname) == true
	//		  alternate email doesn't exist
	public void testGetName_Equal() {
		String firstname = "nina";
		Email email = new Email(firstname, firstname, "001", "12345678");
		String expected = firstname + "." + firstname;
		String actual = email.getName();
		
		assertEquals("Expected non-empty string", 0, actual.length());
		assertTrue("Expected correct fullname", expected.equalsIgnoreCase(actual));
	}
	@Test
	// covers firstname.equalsIgnoreCase(lastname) == false
	//		  alternate email exists
	public void testGetName_NotEqual() {
		String firstname = "Sterling";
		String lastname = "Archer";
		Email email = new Email(firstname, lastname, "001", "12345678");
		email.createAlternateEmail("foo", "bar");
		String expected = firstname + "." + lastname;
		String actual = email.getName();
		
		assertEquals("Expected non-empty string", 0, actual.length());
		assertTrue("Expected correct fullname", expected.equalsIgnoreCase(actual));
	}
	
}
