package backingBeans;

import java.sql.Date;
import java.util.List;

import javax.ejb.EJB;

import bucKonnect.EJB.Entities.UserEntity;
import bucKonnect.EJB.Sessions.UserService;

/**
 * @author Nandkumar
 *
 */
public class UserProfileBean {

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
	private String phone_Number;
	private String dob;
	private String is_Faculty;
	private String department;
	private String major;
	private String about_Me;
	private String interests;

	public String get_Profile() {

		UserEntity user = new UserEntity();
		user.setOSU_Email_Id(loginBean.getName());
		List<List<String>> results = userService.search_Users(user);
		// System.out.println(results.size());
		// System.out.println(results.get(0).get(0));
		// System.out.println(results.get(0).get(1));
		// System.out.println(results.get(0).get(2));
		// System.out.println(results.get(0).get(3));
		// System.out.println(results.get(0).get(4));
		// System.out.println(results.get(0).get(5));
		// System.out.println(results.get(0).get(6));
		// System.out.println(results.get(0).get(7));
		// System.out.println(results.get(0).get(8));
		// System.out.println(results.get(0).get(9));
		setName(results.get(0).get(0));
		setFirstName(results.get(0).get(1));
		setLastName(results.get(0).get(2));
		setPhone_Number(results.get(0).get(3));
		setDob(results.get(0).get(4));
		setIs_Faculty(results.get(0).get(5));
		// if (results.get(0).get(3) != null)
		// userProfileBean.setPhone_Number(Long.parseLong(results.get(0)
		// .get(3)));
		// if (results.get(0).get(4) != null)
		// userProfileBean.setDob(Date.valueOf(results.get(0).get(4)));
		// if (results.get(0).get(5) != null)
		// userProfileBean.setIs_Faculty(Boolean.getBoolean(results.get(0)
		// .get(5)));
		setAbout_Me(results.get(0).get(6));
		setMajor(results.get(0).get(7));
		setDepartment(results.get(0).get(8));
		setInterests(results.get(0).get(9));
		return "userprofile";
	}
	
	public String update_User() {
		UserEntity user = new UserEntity();
		System.out.println(loginBean.getName());
		user.setOSU_Email_Id(loginBean.getName());
		user.setFirst_Name(getFirstName());
		user.setLast_Name(getLastName());
		System.out.println(getLastName());
		user.setPhone_Number(getPhone_Number());
		user.setDob(getDob());
		System.out.println(getIs_Faculty());
		user.setIs_Faculty(getIs_Faculty());
		user.setDepartment(getDepartment());
		user.setMajor(getMajor());
		user.setAbout_Me(getAbout_Me());
		user.setInterests(getInterests());
		String ret = userService.update_User(user);
		if (ret.equalsIgnoreCase("success"))
			return "success";
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
	public String getPhone_Number() {
		return phone_Number;
	}

	/**
	 * @param phone_Number
	 *            the phone_Number to set
	 */
	public void setPhone_Number(String phone_Number) {
		this.phone_Number = phone_Number;
	}

	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return the is_Faculty
	 */
	public String getIs_Faculty() {
		return is_Faculty;
	}

	/**
	 * @param is_Faculty
	 *            the is_Faculty to set
	 */
	public void setIs_Faculty(String is_Faculty) {
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
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
