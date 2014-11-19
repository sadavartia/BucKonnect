package bucKonnect.EJB.Entities;

import java.sql.*;
import javax.persistence.*;

@Entity
@Table(name = "Users")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "User_Id")
	private long user_Id;

	@Column(name = "OSU_Email_Id")
	private String OSU_Email_Id;

	@Column(name = "First_Name")
	private String first_Name;
	
	@Column(name = "Last_Name")
	private String last_Name;

	@Column(name = "Phone_Number")
	private long phone_Number;

	@Column(name = "DOB")
	private Date dob;
	
	@Column(name = "Is_Faculty")
	private boolean is_Faculty;

	@Column(name = "Password")
	private String password;

	@Column(name = "Department")
	private String department;
	
	@Column(name = "Major")
	private String major;
	
	@Column(name = "About_Me")
	private String about_Me;
	
	@Column(name = "Interests")
	private String interests;

	/**
	 * @return the user_Id
	 */
	public long getUser_Id() {
		return user_Id;
	}

	/**
	 * @param user_Id
	 *            the user_Id to set
	 */
	public void setUser_Id(long user_Id) {
		this.user_Id = user_Id;
	}

	/**
	 * @return the oSU_Email_Id
	 */
	public String getOSU_Email_Id() {
		return OSU_Email_Id;
	}

	/**
	 * @param oSU_Email_Id
	 *            the oSU_Email_Id to set
	 */
	public void setOSU_Email_Id(String oSU_Email_Id) {
		OSU_Email_Id = oSU_Email_Id;
	}

	/**
	 * @return the first_Name
	 */
	public String getFirst_Name() {
		return first_Name;
	}

	/**
	 * @param first_Name
	 *            the first_Name to set
	 */
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	/**
	 * @return the last_Name
	 */
	public String getLast_Name() {
		return last_Name;
	}

	/**
	 * @param last_Name
	 *            the last_Name to set
	 */
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	/**
	 * @return the phone_Number
	 */
	public long getPhone_Number() {
		return phone_Number;
	}

	/**
	 * @param phone_Number
	 *            the phone_Number to set
	 */
	public void setPhone_Number(long phone_Number) {
		this.phone_Number = phone_Number;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the is_Faculty
	 */
	public boolean isIs_Faculty() {
		return is_Faculty;
	}

	/**
	 * @param is_Faculty
	 *            the is_Faculty to set
	 */
	public void setIs_Faculty(boolean is_Faculty) {
		this.is_Faculty = is_Faculty;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * @param major
	 *            the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	/**
	 * @return the about_Me
	 */
	public String getAbout_Me() {
		return about_Me;
	}

	/**
	 * @param about_Me
	 *            the about_Me to set
	 */
	public void setAbout_Me(String about_Me) {
		this.about_Me = about_Me;
	}

	/**
	 * @return the interests
	 */
	public String getInterests() {
		return interests;
	}

	/**
	 * @param interests
	 *            the interests to set
	 */
	public void setInterests(String interests) {
		this.interests = interests;
	}

}
