package backingBeans;


import javax.ejb.EJB;

import bucKonnect.EJB.Entities.EventEntity;
import bucKonnect.EJB.Sessions.EventService;

public class CreateEventBean {

	@EJB
	private EventService eventservice;
	private LoginBean loginBean;
	private String eventname;
	private String eventdetails;
	private String name;
	private String eventlocation;
	private String eventinfo;
	private String event_Date_Time;
	private String event_Duration;

	public String createEvent() {
		EventEntity event = new EventEntity();
		event.setEvent_Name(getEventname());
		event.setEvent_Details(getEventdetails());
		event.setPrimary_Event_Coordinator(loginBean.getName());
		event.setEvent_Location(getEventlocation());
		event.setEvent_Info(getEventinfo());
		event.setEvent_Date_Time(getEvent_Date_Time());
		event.setEvent_Duration(getEvent_Duration());

		String ret = eventservice.createEvent(event);
		if (ret.equalsIgnoreCase("success"))
			return "Success";
		else
			return "Error";
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getEventdetails() {
		return eventdetails;
	}

	public void setEventdetails(String eventdetails) {
		this.eventdetails = eventdetails;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEventlocation() {
		return eventlocation;
	}

	public void setEventlocation(String eventlocation) {
		this.eventlocation = eventlocation;
	}

	public String getEventinfo() {
		return eventinfo;
	}

	public void setEventinfo(String eventinfo) {
		this.eventinfo = eventinfo;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public String getEvent_Duration() {
		return (event_Duration);
	}

	public void setEvent_Duration(String event_Duration) {
		this.event_Duration = event_Duration;
	}

	public String getEvent_Date_Time() {
		return (event_Date_Time);
	}

	public void setEvent_Date_Time(String event_Date_Time) {
		this.event_Date_Time = event_Date_Time;
	}
}
