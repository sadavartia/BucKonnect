package backingBeans;

import bucKonnect.EJB.Entities.*;
import bucKonnect.EJB.Sessions.*;
import javax.ejb.EJB;

public class CreateGroupBean {
	@EJB
	private GroupService groupService;
	private LoginBean loginBean;
	

	



	private String groupName;
	private String groupInfo;
	private String category;

	public String createGroup() {
		if (!(getGroupName().isEmpty())) {
			GroupEntity group = new GroupEntity();
			group.setGroup_Name(getGroupName());
			group.setPrimary_Admin(loginBean.getName());
			group.setCategory(getCategory());
			group.setGroup_Info(getGroupInfo());

			String ret = groupService.createGroup(group);
			if (!ret.equalsIgnoreCase("success"))
				return "true";
			else
				return "Error";
		} else
			return "Error";

	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}



	/**
	 * @return the groupInfo
	 */
	public String getGroupInfo() {
		return groupInfo;
	}



	/**
	 * @param groupInfo the groupInfo to set
	 */
	public void setGroupInfo(String groupInfo) {
		this.groupInfo = groupInfo;
	}



	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}



	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

}
