package bucKonnect.EJB.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_Events")
public class UserEventEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "User_Event_Id")	
	private int user_Event_Id;
	
	@Column(name="Event_Name")
    private String event_Name;
    
	@Column(name="User_Name")
    private String user_Name;

	public int getUser_Event_Id() {
		return user_Event_Id;
	}

	public void setUser_Event_Id(int user_Event_Id) {
		this.user_Event_Id = user_Event_Id;
	}

	public String getEvent_Name() {
		return event_Name;
	}

	public void setEvent_Name(String event_Name) {
		this.event_Name = event_Name;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
}