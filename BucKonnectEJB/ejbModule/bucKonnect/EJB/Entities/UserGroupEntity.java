package bucKonnect.EJB.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_Groups")
public class UserGroupEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "User_Group_Id")	
	private int user_Group_Id;
	
	@Column(name="Group_Name")
    private String group_Name;
    
	@Column(name="User_Name")
    private String user_Name;

	public int getUser_Group_Id() {
		return user_Group_Id;
	}

	public void setUser_Group_Id(int user_Group_Id) {
		this.user_Group_Id = user_Group_Id;
	}

	public String getGroup_Name() {
		return group_Name;
	}

	public void setGroup_Name(String group_Name) {
		this.group_Name = group_Name;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
}
