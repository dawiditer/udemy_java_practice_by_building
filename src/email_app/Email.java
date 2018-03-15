package email_app;
/**
 * The {@code Email} class represents an employee's email address
 * belonging to a specific company and an optional department.
 * <p>
 * An email has the following syntax: 
 * <blockquote><pre>
 * firstname.lastname@department.company.com
 * </pre></blockquote></p>
 * <p>
 * An Email object is created by providing the {@code firstname}, {@code lastname},
 * {@code mailcodeCapacity} and an optional {@department}.
 * Once set, the {@code firstname} and {@code lastname} CANNOT be changed 
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
	private String altFirstname;
	private String altLastname;
	private final String departmentCode;
	private String password;
	private int mailCapacity = 250;
	
	// Abstraction Function
	//  Represents the email address of an employee in a company.
	//
	// Representation Invariant
	//	- firstname, lastname, altFirstname and altLastname are non-empty case-insensitive strings
	//	- departmentCode is an empty string if employee has no department
	//  - password must be between 8 and 25 characters long
	//  - mailboxCapacity > 0
	//
	// Safety from Exposure
	//	- All fields are private and can only be accessed via setters and getters
	//	- firstname, lastname and departmentCode are final hence immutable 
	//    and they refer to String objects which are also immutable
	//	- altFirstname, altLastname, password and mailCapacity refer to 
	//	  immutable objects and are only mutated
	//	  via setter methods.
	
	public Email(
			final String firstname, 
			final String lastname,
			final String departmentCode,
			final String password
			) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.altFirstname = this.firstname;
		this.altLastname = this.lastname;
		this.departmentCode = departmentCode;
		this.password = password;
		
		checkRep();
	}
	
	private void checkRep() {
		assert firstname.length() > 0 && lastname.length() > 0;
		assert altFirstname.length() > 0 && altLastname.length() > 0;
		assert 8 <= password.length() && password.length() <= 25;
		assert mailCapacity > 0;
	}
	
	/** Returns a randomly generated password for accessing this email */
	private String generateRandomPassword() {
		throw new RuntimeException("unimplemented");
	}
	/**
	 * Defines an alternate email address.
	 * 
	 * The alternate email address can be used to access this Email
	 * with the same password as the same email address. Once set the email
	 * address cannot be changed.
	 * The alternate email creation is unsuccessful if the alternate email 
	 * is equal(case-insensitive) to the main email address.
	 * 
	 * @param altFirstname non-empty non-null case-insensitive String
	 * @param altLastname non-empty non-null case-insensitive String
	 * @return true if an alternate email address has been successfully created,
	 *         false otherwise.
	 */
	public boolean createAlternateEmail(final String altFirstname, final String altLastname) {
		throw new RuntimeException("unimplemented");
	}	
	/** Returns the case-insensitive fullname used in this email address as firstname.lastname */
	public String getName() {
		throw new RuntimeException("unimplemented");
	}
	/** Returns the case-insensitive alternate fullname used in this email address as altfirstname.altlastname */
	public String getAltName() {
		throw new RuntimeException("unimplemented");
	}
	/** Returns the department code associated with this email */
	public String getDepartmentCode() {
		throw new RuntimeException("unimplemented");
	}
	/** Returns the current mail capacity for this email */
	public String getMailCapacity() {
		throw new RuntimeException("unimplemented");
	}
	/** Returns the full string rep of this email address as  firstname.lastname@department.company.com */
	public String getEmailAddress(){
		throw new RuntimeException("unimplemented");
	}
	/** Returns the full string rep of the alternate email address if set, empty string otherwise*/
	public String getAltEmailAddress(){
		throw new RuntimeException("unimplemented");
	}
	/**
	 * Changes the current password of this email to newPassword
	 * 
	 * @param newPassword non-empty non-null case-sensitive String.
	 *        requires 8 <= newPassword.length() <= 25
	 * @return true if password has been succesfully been changed
	 * 		   to newPassword, false otherwise.
	 */
	public boolean resetPassword(final String newPassword) {
		throw new RuntimeException("unimplemented");
	}
	/**
	 * Changes the current mail capacity to new capacity
	 * 
	 * @param newMailCapacity requires integer > 0
	 * @return previous mail capacity if change was successful,
	 * 		   -1 if unsuccessful.
	 */
	public int setMailCapacity(final int newMailCapacity) {
		throw new RuntimeException("unimplemented");
	}
	
}
