package bucKonnect.EJB.Entities;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Events")
public class EventEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Event_Id")
	private long event_Id;

	public long getEvent_Id() {
		return event_Id;
	}

	public void setEvent_Id(long event_Id) {
		this.event_Id = event_Id;
	}	
	
	@Column(name = "Event_Name")
	private String event_Name;
	
	public String getEvent_Name() {
		return event_Name;
	}

	public void setEvent_Name(String event_Name) {
		this.event_Name = event_Name;
	}

	@Column(name ="Event_Details")
	private String event_Details;
	
	public String getEvent_Details() {
		return event_Details;
	}

	public void setEvent_Details(String event_Details) {
		this.event_Details = event_Details;
	}	
	
	@Column(name="Primary_Event_Coordinator")
	private long primary_Event_Coordinator;
	
	public long getPrimary_Event_Coordinator() {
		return primary_Event_Coordinator;
	}

	public void setPrimary_Event_Coordinator(long primary_Event_Coordinator) {
		this.primary_Event_Coordinator = primary_Event_Coordinator;
	}	
	
	@Column(name="Event_Location")
	private String event_Location;
	
	public String getEvent_Location() {
		return event_Location;
	}

	public void setEvent_Location(String event_Location) {
		this.event_Location = event_Location;
	}	
	
	@Column(name="Event_Info ")
	private String event_Info;
	public String getEvent_Info() {
		return event_Info;
	}

	public void setEvent_Info(String event_Info) {
		this.event_Info = event_Info;
	}	
	
	@Column(name = "Event_Date_Time")
	private Date event_Date_Time;
	public Date getEvent_Date_Time() {
		return event_Date_Time;
	}

	public void setEvent_Date_Time(Date event_Date_Time) {
		this.event_Date_Time = event_Date_Time;
	}	
	
	@Column(name="Event_Duration")
	private Time event_Duration;
	public Time getEvent_Duration() {
		return event_Duration;
	}

	public void setEvent_Duration(Time event_Duration) {
		this.event_Duration = event_Duration;
	}	
}