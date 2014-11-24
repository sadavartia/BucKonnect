package backingBeans;

import java.sql.Date;

import javax.ejb.EJB;

import bucKonnect.EJB.Entities.UserEntity;
import bucKonnect.EJB.Sessions.UserService;

/**
 * @author Nandkumar
 *
 */
public class UpdateUserProfileBean {
	
	private LoginBean loginBean;
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	
	@EJB
	private UserService userService;
	private String name;
	private String firstName;
	private String lastName;
	private long phone_Number;
	private Date dob;
	private boolean is_Faculty;
	private String department;
	private String major;
	private String about_Me;
	private String interests;

	public String update_User() {
		UserEntity user = new UserEntity();
		user.setOSU_Email_Id(loginBean.getName());
		user.setFirst_Name(getFirstName());
		user.setLast_Name(getLastName());
		user.setPhone_Number(getPhone_Number());
		user.setDob(getDob());
		user.setIs_Faculty(isIs_Faculty());
		user.setDepartment(getDepartment());
		user.setMajor(getMajor());
		user.setAbout_Me(getAbout_Me());
		user.setInterests(getInterests());
		String ret = userService.update_User(user);
		if (ret.equalsIgnoreCase("success"))
			return "Success";
		else
			return "Failure";
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
