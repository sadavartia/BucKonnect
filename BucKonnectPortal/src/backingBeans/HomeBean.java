package backingBeans;

import java.sql.Date;
import java.util.List;

import javax.ejb.EJB;

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

	private SearchUserGroupBean searchUserGroupBean;

	public SearchUserGroupBean getSearchUserGroupBean() {
		return searchUserGroupBean;
	}

	public void setSearchUserGroupBean(SearchUserGroupBean searchUserGroupBean) {
		this.searchUserGroupBean = searchUserGroupBean;
	}
}
