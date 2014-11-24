package backingBeans;

import javax.ejb.EJB;

import bucKonnect.EJB.Entities.EventEntity;
import bucKonnect.EJB.Entities.GroupEntity;
import bucKonnect.EJB.Sessions.EventService;

public class CreateEventBean {

	@EJB
	private EventService eventservice;
	private String eventname;
	private String eventdetails;
	private long pec;
	private String eventlocation;
	private String eventinfo;

	public String createEvent() {
		EventEntity event = new EventEntity();
		event.setEvent_Name(getEventname());
		event.setEvent_Details(getEventdetails());
		event.setPrimary_Event_Coordinator(getPec());
		event.setEvent_Location(getEventlocation());
		event.setEvent_Info(getEventinfo());

		String ret = eventservice.createEvent(event);
		if (!ret.equalsIgnoreCase("success"))
			return "true";
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

	public long getPec() {
		return pec;
	}

	public void setPec(long pec) {
		this.pec = pec;
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
}
