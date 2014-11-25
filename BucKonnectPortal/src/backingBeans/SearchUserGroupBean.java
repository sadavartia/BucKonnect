package backingBeans;

import java.util.List;

import bucKonnect.EJB.Entities.*;
import bucKonnect.EJB.Sessions.*;

import javax.ejb.EJB;

public class SearchUserGroupBean {

	@EJB
	private UserGroupService userGroupService;

	private String groupName;

	private List<List<String>> userGroups;

	public String searchGroup() {
		if (!(getGroupName()).isEmpty()) {
			GroupEntity group = new GroupEntity();
			group.setGroup_Name(getGroupName());
			group.setCategory(getCategory());
			userGroups = userGroupService.search_Groups(group);

			return "Success";

		} else
			return "Error";

	}

	public List<List<String>> getSearch_List() {
		return Search_List;
	}

	public void setSearch_List(List<List<String>> search_List) {
		Search_List = search_List;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
