package email_app;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmailAppTest {
	// Partition the input as follows:
	//	createAlternateEmail(altFirstname, altLastname) -> boolean
	//		altFirstname.equalsIgnoreCase(firstname): true, false
	//		altLastname.equalsIgnoreCase(lastname): true, false
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
	// Coverage: Exhaustive enumeration of partitons
}
