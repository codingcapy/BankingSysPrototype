/*
 * author: Paul Kim
 * date: February 4, 2023
 * version: 1.0
 * This is a banking system prototype program
 */

import java.util.Date;

public class Profile {
	private String profileNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private String birthYear;
	private String birthMonth;
	private String birthDay;
	private String streetAddress;
	private String city;
	private String province;
	private String postalCode;
	private String country;
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
	 * @param middleName
	 * @param lastName
	 * @param birthDay
	 * @param birthMonth
	 * @param birthYear
	 * @param streetAddress
	 * @param city
	 * @param province
	 * @param postalCode
	 * @param country
	 * @param phoneNumber
	 * @param emailAddress
	 */
	public Profile(String profileNumber, String firstName, String middleName, String lastName, String birthYear, 
			String birthMonth, String birthDay, String streetAddress, String city, String province, String postalCode,
			String country, String phoneNumber, String emailAddress) {
		super();
		this.profileNumber = profileNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
		this.streetAddress = streetAddress;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
		this.country = country;
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
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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
	 * @return the birthDay
	 */
	public String getBirthDay() {
		return birthDay;
	}

	/**
	 * @param birthDay the birthDay to set
	 */
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	/**
	 * @return the birthMonth
	 */
	public String getBirthMonth() {
		return birthMonth;
	}

	/**
	 * @param birthMonth the birthMonth to set
	 */
	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}

	/**
	 * @return the birthYear
	 */
	public String getBirthYear() {
		return birthYear;
	}

	/**
	 * @param birthYear the birthYear to set
	 */
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	/**
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}

	/**
	 * @param streetAddress the streetAddress to set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
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
				+ " | Date of Birth: " + birthYear + "-" + birthMonth + "-" + birthDay + " | Address: " + streetAddress + ", " + city + ", " + province 
				+ ", " + postalCode + ", " + country + " | Phone Number: " + phoneNumber + " | Email Address: " + emailAddress;
	}
	public String profileData() {
		return profileNumber + "," + firstName + "," + middleName + "," + lastName + "," + birthYear + "," + birthMonth + "," + birthDay + "," 
	+ streetAddress + "," + city + "," + province + "," + postalCode + "," + country + "," +  phoneNumber + "," +  emailAddress + "\n";
	}
}
