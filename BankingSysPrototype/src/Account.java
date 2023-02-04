
public class Account {
	private String profileNumber;
	private String accountNumber;
	private String accountType;
	private double interestRate;
	private double accountBalance;
	/**
	 * 
	 */
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param profileNumber
	 * @param accountNumber
	 * @param accountType
	 * @param accountBalance
	 */
	public Account(String profileNumber, String accountNumber, String accountType, double interestRate, double accountBalance) {
		super();
		this.profileNumber = profileNumber;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.interestRate = interestRate;
		this.accountBalance = accountBalance;
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
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	/**
	 * @return the accountType
	 */
	public double getInterestRate() {
		return interestRate;
	}
	/**
	 * @param accountType the accountType to set
	 */
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	/**
	 * @return the accountBalance
	 */
	public double getAccountBalance() {
		return accountBalance;
	}
	/**
	 * @param accountBalance the accountBalance to set
	 */
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "Account Number: " + accountNumber + " | Account Type: "
				+ accountType + " | Interest Rate: " + interestRate + " | Account Balance: " + accountBalance;
	}
	public String accountData() {
		return profileNumber + "," +accountNumber + "," + accountType + "," + interestRate + "," + accountBalance + "\n";
	}
}
