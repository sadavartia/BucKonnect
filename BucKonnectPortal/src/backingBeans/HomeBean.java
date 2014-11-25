package backingBeans;

import java.sql.Date;
import java.util.List;

import javax.ejb.EJB;

import bucKonnect.EJB.Entities.UserEntity;
import bucKonnect.EJB.Sessions.UserService;

public class HomeBean {

	private LoginBean loginBean;

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	private UserProfileBean userProfileBean;

	public UserProfileBean getUserProfileBean() {
		return userProfileBean;
	}

	public void setUserProfileBean(UserProfileBean userProfileBean) {
		this.userProfileBean = userProfileBean;
	}

	@EJB
	private UserService userService;

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
		userProfileBean.setName(results.get(0).get(0));
		userProfileBean.setFirstName(results.get(0).get(1));
		userProfileBean.setLastName(results.get(0).get(2));
		userProfileBean.setPhone_Number(results.get(0).get(3));
		userProfileBean.setDob(results.get(0).get(4));
		userProfileBean.setIs_Faculty(results.get(0).get(5));
		// if (results.get(0).get(3) != null)
		// userProfileBean.setPhone_Number(Long.parseLong(results.get(0)
		// .get(3)));
		// if (results.get(0).get(4) != null)
		// userProfileBean.setDob(Date.valueOf(results.get(0).get(4)));
		// if (results.get(0).get(5) != null)
		// userProfileBean.setIs_Faculty(Boolean.getBoolean(results.get(0)
		// .get(5)));
		userProfileBean.setAbout_Me(results.get(0).get(6));
		userProfileBean.setMajor(results.get(0).get(7));
		userProfileBean.setDepartment(results.get(0).get(8));
		userProfileBean.setInterests(results.get(0).get(9));
		return "userprofile";

	}
}
