package bucKonnect.EJB.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Groups")
public class GroupEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Group_Id")	
	private long group_Id;    
	
	@Column(name="Group_Name")
    private String group_Name;
    
	@Column(name="Group_Info")
    private String group_Info;
    
	@Column(name="Primary_Admin")
    private String primary_Admin;
    
	@Column(name="Category")
    private String category;

	/**
	 * @return the group_Id
	 */
	public long getGroup_Id() {
		return group_Id;
	}

	/**
	 * @param group_Id the group_Id to set
	 */
	public void setGroup_Id(long group_Id) {
		this.group_Id = group_Id;
	}

	/**
	 * @return the group_Name
	 */
	public String getGroup_Name() {
		return group_Name;
	}

	/**
	 * @param group_Name the group_Name to set
	 */
	public void setGroup_Name(String group_Name) {
		this.group_Name = group_Name;
	}

	/**
	 * @return the group_Info
	 */
	public String getGroup_Info() {
		return group_Info;
	}

	/**
	 * @param group_Info the group_Info to set
	 */
	public void setGroup_Info(String group_Info) {
		this.group_Info = group_Info;
	}

	/**
	 * @return the primary_Admin
	 */
	public String getPrimary_Admin() {
		return primary_Admin;
	}

	/**
	 * @param primary_Admin the primary_Admin to set
	 */
	public void setPrimary_Admin(String primary_Admin) {
		this.primary_Admin = primary_Admin;
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
    
}
