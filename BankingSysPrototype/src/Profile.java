import java.util.Date;

public class Profile {
	private String profileNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dateOfBirth;
	private String address;
	private String phoneNumber;
	private String emailAddress;
	/**
	 * 
	 */
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param profileNumber
	 * @param firstName
	 * @param lastName
	 * @param dateOfBirth
	 * @param address
	 * @param phoneNumber
	 * @param emailAddress
	 */
	public Profile(String profileNumber, String firstName, String middleName, String lastName, String dateOfBirth, String address,
			String phoneNumber, String emailAddress) {
		super();
		this.profileNumber = profileNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}
	/**
	 * @return the profileNumber
	 */
	public String getProfileNumber() {
		return profileNumber;
	}
	/**
	 * @param profileNumber the profileNumber to set
	 */
	public void setProfileNumber(String profileNumber) {
		this.profileNumber = profileNumber;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return firstName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void middleName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	@Override
	public String toString() {
		return "Profile Number: " + profileNumber + " | First Name: " + firstName + " | Middle Name: " + middleName + " | Last Name: " + lastName
				+ " | Date of Birth: " + dateOfBirth + " | Address: " + address + " | Phone Number: " + phoneNumber
				+ " | Email Address: " + emailAddress;
	}
	public String profileData() {
		return profileNumber + "," + firstName + "," + middleName + "," + lastName + "," + dateOfBirth + "," + address + "," +  phoneNumber + "," +  emailAddress + "\n";
	}
}
