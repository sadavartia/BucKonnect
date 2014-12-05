package backingBeans;

import java.util.List;

import bucKonnect.EJB.Entities.*;
import bucKonnect.EJB.Sessions.*;

import javax.ejb.EJB;

public class SearchUserEventBean {

	@EJB
	private UserEventService userEventService;

	private LoginBean loginBean;

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	private List<List<String>> userEvents;

	public String get_User_Events() {
		UserEntity user = new UserEntity();
		System.out.println(loginBean.getName());
		user.setOSU_Email_Id(loginBean.getName());

		userEvents = userEventService.searchUserEvents(user);
		return "UserEvents";
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
		return userEvents;
	}

	public void setSearch_List(List<List<String>> userEvents) {
		this.userEvents = userEvents;
	}
}