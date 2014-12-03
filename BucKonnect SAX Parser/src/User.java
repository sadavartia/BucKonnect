public class User {
	private String OSU_Email_ID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String dob;
	private boolean isFaculty;
	private String password;
	private String aboutMe;
	private String major;
	private String interests;

	public User() {
	}

	public User(String OSU_Email_ID, String firstName,
			String lastName, String phoneNumber, String dob, boolean isFaculty,
			String password, String aboutMe, String major, String interests) {
		this.OSU_Email_ID = OSU_Email_ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.isFaculty = isFaculty;
		this.password = password;
		this.aboutMe = aboutMe;
		this.interests = interests;
		this.major = major;

	}

	public String getOSUID() {
		return OSU_Email_ID;
	}

	public void setOSUID(String OSU_Email_ID) {
		this.OSU_Email_ID = OSU_Email_ID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDate() {
		return dob;
	}

	public void setDate(String dob) {
		this.dob = dob;
	}

	public boolean getFaculty() {
		return isFaculty;
	}

	public void setFaculty(boolean isF) {
		this.isFaculty = isF;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("User Details - ");
		sb.append("OSU Email ID:" + getOSUID());
		sb.append(", ");
		sb.append("Name:" + getFirstName() + getlastName());
		sb.append(", ");
		sb.append("Phone Number:" + getPhoneNumber());
		sb.append(", ");
		sb.append("Date Of Birth:" + getDate());
		sb.append(", ");
		sb.append("Is Faculty or Not:" + getFaculty());
		sb.append(", ");
		sb.append("About Me:" + getAboutMe());
		sb.append(", ");
		sb.append("Interests:" + getInterests());
		sb.append(",");
		sb.append("Major:" + getMajor());
		sb.append(".");

		return sb.toString();
	}

}
