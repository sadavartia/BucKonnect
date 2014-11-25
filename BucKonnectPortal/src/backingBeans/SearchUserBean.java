package backingBeans;

import java.util.List;

import bucKonnect.EJB.Entities.*;
import bucKonnect.EJB.Sessions.*;

import javax.ejb.EJB;

public class SearchUserBean {

	@EJB
	private UserService userService;
	private String OSU_Email_Id;

	private String first_Name;
	private String last_Name;

	private List<List<String>> Search_List;

	public String getOSU_Email_Id() {
		return OSU_Email_Id;
	}

	public void setOSU_Email_Id(String oSU_Email_Id) {
		OSU_Email_Id = oSU_Email_Id;
	}

	public String searchUser() {
		if (!(getOSU_Email_Id().isEmpty())) {
			UserEntity user = new UserEntity();
			user.setFirst_Name(getFirst_Name());
			user.setOSU_Email_Id(getOSU_Email_Id());
			user.setLast_Name(getLast_Name());

			Search_List = userService.search_Users(user);

			if (Search_List.size() > 0)
				return "Success";
			else
				return "Error";
		} else
			return "Error";

	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public List<List<String>> getSearch_List() {
		return Search_List;
	}

	public void setSearch_List(List<List<String>> search_List) {
		Search_List = search_List;
	}

}
