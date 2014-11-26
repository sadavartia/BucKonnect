package backingBeans;

import java.util.List;

import bucKonnect.EJB.Entities.*;
import bucKonnect.EJB.Sessions.*;

import javax.ejb.EJB;

public class SearchUserGroupBean {

	@EJB
	private UserGroupService userGroupService;

	private LoginBean loginBean;

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	private List<List<String>> userGroups;

	public String get_User_Groups() {
		UserEntity user = new UserEntity();
		System.out.println(loginBean.getName());
		user.setOSU_Email_Id(loginBean.getName());

		userGroups = userGroupService.searchUserGroups(user);
		if (userGroups.size() > 0)
			return "searchusergroup";
		else
			return "Error";
	}

	// public String searchGroup() {

	// userGroupService.searchUserGroups(user);

	// GroupEntity group = new GroupEntity();
	// group.setGroup_Name(getGroupName());
	// group.setCategory(getCategory());
	// userGroups = userGroupService.search_Groups(group);

	// return "Success";
	// }

	public List<List<String>> getSearch_List() {
		return userGroups;
	}

	public void setSearch_List(List<List<String>> userGroups) {
		this.userGroups = userGroups;
	}
}
