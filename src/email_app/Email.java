package email_app;
/**
 * The {@code Email} class represents an employee's email address
 * belonging to a specific company and an optional department.
 * <p>
 * An email has the following syntax: 
 * <blockquote><pre>
 * firstname.secondname@department.company.com
 * </pre></blockquote></p>
 * <p>
 * An Email object is created by providing the {@code firstname}, {@code lastname},
 * {@code mailcodeCapacity} and an optional {@department}. 
 * A random password is generated when
 * an email account is created, with the owner having the option of
 * changing the password an arbitrary number of times.
 * A default {@code mailboxCapacity} is assigned to which a user
 * can change.</p>
 * <p>
 * The class includes options to include an alternate email.
 * </p>
 * 
 * @author dawiditer
 *
 */
public class Email {
	private final String firstname;
	private final String lastname;
	private String department_code = "";
	private String password;
	private int mailCapacity = 250;
	
	// Abstraction Function
	//  Represents the email address of an employee in a company.
	//
	// Representation Invariant
	//	- firstname and lastname are non-empty strings
	//	- department_code is an empty string if employee has no department
	//  - password must be between 8 and 25 characters long
	//  - mailboxCapacity > 0
	//
	// Safety from Exposure
	//	- All fields are private and can only be accessed via setters and getters
	//	- firstname and lastname are final hence immutable and they refer to Strings which are
	//	  also immutable
	//	- department_code, password and mailCapacity refer to immutable objects and are only mutated
	//	  via setter methods.
	
	private void checkRep() {
		assert firstname.length() > 0 && lastname.length() > 0;
		assert 8 <= password.length() && password.length() <= 25;
		assert mailCapacity > 0;
	}
	
	public Email(
			final String firstname, 
			final String lastname,
			final String department_code,
			final String password
			) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.department_code = department_code;
		this.password = password;
		
		checkRep();
	}
	
	
}
