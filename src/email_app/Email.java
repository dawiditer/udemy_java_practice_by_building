package email_app;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;

/**
 * The {@code Email} class represents an employee's email address
 * belonging to a specific company and an optional department. If no department
 * is defined, "general" is set as the default department.
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
	private String altFirstname = "";
	private String altLastname = "";
	private final String departmentCode;
	private String password;
	private int mailCapacity = 250;
	
	// Abstraction Function
	//  Represents the email address of an employee in a company.
	//
	// Representation Invariant
	//	- firstname, lastname, altFirstname and altLastname are non-empty case-insensitive strings
	//	- departmentCode is a non-empty case-insensitive string
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
	
	// TODO: password encryption
	public Email(
			final String firstname, 
			final String lastname,
			final String departmentCode
			) {
		this.firstname = firstname.trim().toLowerCase();
		this.lastname = lastname.trim().toLowerCase();
		this.departmentCode = departmentCode.trim().isEmpty() ? "general" : departmentCode.toLowerCase();
		this.password = generateRandomPassword();
		
		checkRep();
	}
	
	private void checkRep() {
		assert !firstname.isEmpty() && !lastname.isEmpty();
		assert !altFirstname.isEmpty() && !altLastname.isEmpty();
		assert 8 <= password.length() && password.length() <= 25;
		assert mailCapacity > 0;
	}
	
	/** Returns a randomly generated password for accessing this email */
	// TODO: make private. Made public for testing
	public static String generateRandomPassword() {
		final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final String lower = upper.toLowerCase(Locale.ROOT);
		final String digits = "0123456789";
		final String alphanum = upper + lower + digits;
		final Random random = new SecureRandom();
		
		final char[] symbols = alphanum.toCharArray();
		final char[] buffer = new char[symbols.length];
		for (int index = 0; index < 25; index++) {
			buffer[index] = symbols[random.nextInt(symbols.length)];
		}
		
		return new String(buffer);
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
		assert !altFirstname.isEmpty();
		assert !altLastname.isEmpty();
		
		if (this.firstname.equalsIgnoreCase(altFirstname) && this.lastname.equalsIgnoreCase(altLastname)) {
			return false;
		}
		this.altFirstname = altFirstname.toLowerCase();
		this.altLastname = altLastname.toLowerCase();
		
		checkRep();
		return true;
	}	
	/** Returns the fullname(in lowercase) used in this email address as firstname.lastname */
	public String getName() {
		return this.firstname + "." + this.lastname;
	}
	/** Returns the alternate fullname(in lowercase) as altfirstname.altlastname if defined, "" otherwise */
	public String getAltName() {
		return altFirstname.isEmpty() && altLastname.isEmpty() ? "" : altFirstname + "." + altLastname;
	}
	/** Returns the defined department code(in lowercase) associated with this email, "general" if not defined */
	public String getDepartmentCode() {
		return departmentCode;
	}
	/** Returns the current mail capacity for this email */
	public int getMailCapacity() {
		return mailCapacity;
	}
	/** Returns the full lowercase string rep of this email address as firstname.lastname@departmentcode.company.com */
	public String getEmailAddress(){
		String localPart = this.getName();
		String domain = departmentCode + ".company.com";
		
		return localPart + "@" + domain;
	}
	/** Returns the full lowercase string rep of the alternate email address if set, empty string otherwise*/
	public String getAltEmailAddress(){
		String localPart = this.getAltName();
		String domain = departmentCode + ".company.com";
		
		return localPart.isEmpty() ? "" : localPart + "@" + domain;
	}
	/**
	 * Changes the current password of this email to newPassword
	 * 
	 * @param newPassword non-empty non-null case-sensitive String.
	 *        requires 8 <= newPassword.length() <= 25
	 * @return true if and only if password has been successfully changed
	 * 		   to newPassword, false otherwise. 
	 */
	public boolean resetPassword(final String newPassword) {
		assert newPassword.length() <= 8 && newPassword.length() <= 25;
		
		if (newPassword == this.password) {
			return false;
		}
		
		this.password = newPassword;
		
		checkRep();
		return true;
	}
	/**
	 * Changes the current mail capacity to new capacity
	 * 
	 * @param newMailCapacity requires integer > 0
	 * @return previous mail capacity if change was successful,
	 * 		   -1 if unsuccessful.
	 */
	public int setMailCapacity(final int newMailCapacity) {
		assert newMailCapacity > 0;
		
		if (newMailCapacity < Integer.MIN_VALUE || newMailCapacity > Integer.MAX_VALUE) {
			return -1;
		}
		int prev = this.mailCapacity;
		this.mailCapacity = newMailCapacity;
		
		checkRep();
		return prev;
	}
	
}
