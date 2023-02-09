
public class Note {
	private String profileNumber;
	private String note;
	/**
	 * 
	 */
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param profileNumber
	 * @param note
	 */
	public Note(String profileNumber, String note) {
		super();
		this.profileNumber = profileNumber;
		this.note = note;
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
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return note;
	}
	public String noteData() {
		return profileNumber + "," + note + "\n";
	}
}
