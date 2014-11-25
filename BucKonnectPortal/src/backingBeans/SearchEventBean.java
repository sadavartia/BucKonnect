package backingBeans;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import bucKonnect.EJB.Entities.*;
import bucKonnect.EJB.Sessions.*;

import javax.ejb.EJB;

import sun.security.action.GetLongAction;

public class SearchEventBean {

    @EJB
	private EventService eventService;
	private String event_Name;
	private String event_Details;
	private long primary_Event_Coordinator;
	private String event_Location;
	private String event_Info;
	private Date event_Date_Time;
	private Time event_Duration;
	

	private List<List<String>> Search_List;

	
	public String searchEvent() {
		if (!(getEvent_Name()).isEmpty()) {
			EventEntity event = new EventEntity();
			event.setEvent_Name(getEvent_Name());
			event.setEvent_Location(getEvent_Location());
			Search_List = eventService.search_Events(event);
		
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

	public String getEvent_Name() {
		return event_Name;
	}

	public void setEvent_Name(String event_Name) {
		this.event_Name = event_Name;
	}

	public String getEvent_Details() {
		return event_Details;
	}

	public void setEvent_Details(String event_Details) {
		this.event_Details = event_Details;
	}

	public long getPrimary_Event_Coordinator() {
		return primary_Event_Coordinator;
	}

	public void setPrimary_Event_Coordinator(long primary_Event_Coordinator) {
		this.primary_Event_Coordinator = primary_Event_Coordinator;
	}

	public String getEvent_Location() {
		return event_Location;
	}

	public void setEvent_Location(String event_Location) {
		this.event_Location = event_Location;
	}

	public String getEvent_Info() {
		return event_Info;
	}

	public void setEvent_Info(String event_Info) {
		this.event_Info = event_Info;
	}

	public Date getEvent_Date_Time() {
		return event_Date_Time;
	}

	public void setEvent_Date_Time(Date event_Date_Time) {
		this.event_Date_Time = event_Date_Time;
	}

	public Time getEvent_Duration() {
		return event_Duration;
	}

	public void setEvent_Duration(Time event_Duration) {
		this.event_Duration = event_Duration;
	}
}

